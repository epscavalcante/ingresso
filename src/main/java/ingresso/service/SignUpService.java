package ingresso.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.dto.signup.CandidateCheckDto;
import ingresso.exception.AppException;
import ingresso.model.Candidate;
import ingresso.model.Person;
import ingresso.repository.CandidateRepository;
import ingresso.repository.PersonRepository;

@Service
public class SignUpService {

	@Autowired
	private StepService stepService;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private CandidateRepository candidateRepository;

	public void check(CandidateCheckDto candidateCheckDto) {
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
	}

}
