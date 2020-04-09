package ingresso.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ingresso.dto.authentication.UserInfoDto;
import ingresso.dto.user.CandidateCheckDto;
import ingresso.dto.user.SignUpDto;
import ingresso.exception.AppException;
import ingresso.model.Candidate;
import ingresso.model.Person;
import ingresso.model.Role;
import ingresso.model.User;
import ingresso.repository.CandidateRepository;
import ingresso.repository.PersonRepository;
import ingresso.repository.RoleRepository;
import ingresso.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private StepService stepService;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public SignUpDto check(CandidateCheckDto candidateCheckDto) {
		stepService.checkPeriodEnrollment(candidateCheckDto.getSelectiveProcessId());
		Optional<Person> optionalPerson = personRepository.findByCpfAndEmail(candidateCheckDto.getCpf(),
				candidateCheckDto.getEmail());
		if (optionalPerson.isEmpty()) {
			throw new AppException("Nenhum candidato existe com este CPF e/ou Email para o Processo Seletivo vigente.");
		}
		Optional<Candidate> optionalCandidate = candidateRepository
				.findByPersonAndSelectiveProcessId(optionalPerson.get(), candidateCheckDto.getSelectiveProcessId());
		if (optionalCandidate.isEmpty()) {
			throw new AppException("Candidato NÃO INSCRITO para este Processo Seletivo.");
		}
		if (optionalCandidate.get().forbiddenEnrollment()) {
			throw new AppException("Período de Pré-Matrícula ENCERRADO.");
		}
		SignUpDto signUpDto = new SignUpDto();
		signUpDto.setEmail(optionalPerson.get().getEmail());
		signUpDto.setCpf(optionalPerson.get().getCpf());
		return signUpDto;
	}

	@Transactional
	public UserInfoDto create(SignUpDto signUpDto) {
		if (!signUpDto.getEmail().equals(signUpDto.getConfirmEmail())) {
			throw new AppException("E-mails devem ser iguais!");
		}
		if (!signUpDto.getPassword().equals(signUpDto.getConfirmPassword())) {
			throw new AppException("Senhas devem ser iguais!");
		}
		if (userRepository.findByEmail(signUpDto.getEmail()).isPresent()) {
			throw new AppException("E-mail já cadastrado para outro candidato!");
		}

		Person person = personRepository.findByCpf(signUpDto.getCpf()).get();
		Role role = roleRepository.findByName("ROLE_CANDIDATE").get();

		User user = new User();
		user.getRoles().add(role);
		user.setEmail(signUpDto.getEmail());
		user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
		user.setName(person.getName());

		userRepository.save(user);

		return new UserInfoDto(signUpDto.getEmail(), signUpDto.getPassword());
	}
}
