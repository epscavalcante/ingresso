package ingresso.service;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.dto.RegistrationDto;
import ingresso.model.Candidate;
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
		return build(candidateRepository.findById(id).get());
	}

	@Transactional
	public RegistrationDto save(Integer candidateId, RegistrationDto dto) {
		Candidate candidate = candidateRepository.findById(candidateId).get();
		modelMapper.map(dto, candidate.getPerson());
		modelMapper.map(dto.getJob(), candidate.getJob());
		candidateRepository.save(candidate);
		return build(candidate);
	}

	private RegistrationDto build(Candidate candidate) {
		RegistrationDto registrationDto = new RegistrationDto();
		modelMapper.map(candidate.getPerson(), registrationDto);
		modelMapper.map(candidate.getJob(), registrationDto.getJob());
		return registrationDto;
	}

}
