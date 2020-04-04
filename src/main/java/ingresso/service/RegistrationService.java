package ingresso.service;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.dto.RegistrationDto;
import ingresso.model.Candidate;
import ingresso.model.CandidateStatus;
import ingresso.model.Job;
import ingresso.model.Person;
import ingresso.repository.CandidateRepository;
import ingresso.repository.PersonRepository;

@Service
public class RegistrationService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private PersonRepository personRepository;

	public Collection<RegistrationDto> findAll() {
		return personRepository.findAll().stream().map(p -> modelMapper.map(p, RegistrationDto.class))
				.collect(Collectors.toList());
	}

	public RegistrationDto findById(Integer id) {
		return modelMapper.map(personRepository.findById(id).get(), RegistrationDto.class);
	}

	@Transactional
	public RegistrationDto save(Integer candidateId, RegistrationDto dto) {
		Person person = modelMapper.map(dto, Person.class);
		Job job = modelMapper.map(dto.getJob(), Job.class);
		Candidate candidate = candidateRepository.findById(candidateId).get();

		if (Objects.isNull(candidate.getJob())) {
			candidate.setJob(new Job());
		}
		BeanUtils.copyProperties(job, candidate.getJob(), "id");
		candidate.setStatus(CandidateStatus.ENROLLED);
		candidateRepository.save(candidate);

		Person savedPerson = candidate.getPerson();
		BeanUtils.copyProperties(person, savedPerson, "id", "name", "cpf");
		savedPerson = personRepository.save(savedPerson);

		RegistrationDto registrationDto = new RegistrationDto();
		modelMapper.map(savedPerson, registrationDto);
		modelMapper.map(candidate.getJob(), registrationDto.getJob());

		return registrationDto;
	}
}
