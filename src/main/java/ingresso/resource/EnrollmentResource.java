package ingresso.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ingresso.dto.EnrollmentDto;
import ingresso.service.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentResource {

	@Autowired
	private EnrollmentService service;

	@GetMapping("/{id}")
	public EnrollmentDto findById(@PathVariable("id") Integer candidateId) {
		return service.findById(candidateId);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public EnrollmentDto create(@PathVariable("id") Integer candidateId, @Valid @RequestBody EnrollmentDto resource) {
		return service.save(candidateId, resource);
	}
}
