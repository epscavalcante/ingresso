package ingresso.service;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.dto.RegistrationDto;
import ingresso.model.Person;
import ingresso.repository.PersonRepository;

@Service
public class RegistrationService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PersonRepository personRepository;

	public Collection<RegistrationDto> findAll() {
		return personRepository.findAll().stream().map(p -> modelMapper.map(p, RegistrationDto.class))
				.collect(Collectors.toList());
	}

	@Transactional
	public RegistrationDto create(RegistrationDto dto) {
		Person person = modelMapper.map(dto, Person.class);
		return modelMapper.map(personRepository.save(person), RegistrationDto.class);
	}
}
