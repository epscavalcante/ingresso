package ingresso.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ingresso.dto.JobDto;
import ingresso.dto.RegistrationDto;
import ingresso.model.Job;
import ingresso.model.Person;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.createTypeMap(RegistrationDto.class, Person.class).addMappings(mapper -> mapper.skip(Person::setId))
				.addMappings(mapper -> mapper.skip(Person::setName)).addMappings(mapper -> mapper.skip(Person::setCpf));

		modelMapper.createTypeMap(JobDto.class, Job.class).addMappings(mapper -> mapper.skip(Job::setId));

		return modelMapper;
	}

}
