package ingresso.resource;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ingresso.dto.RegistrationDto;
import ingresso.service.RegistrationService;

@RestController
@RequestMapping("/registrations")
public class RegistrationResource {

	@Autowired
	private RegistrationService service;

	@GetMapping
	public Collection<RegistrationDto> findAll() {
		return service.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RegistrationDto create(@Valid @RequestBody RegistrationDto resource) {
		return service.create(resource);
	}
}
