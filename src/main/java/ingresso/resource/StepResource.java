package ingresso.resource;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.Step;
import ingresso.service.StepService;

@RestController
@RequestMapping("/steps")
public class StepResource {

	@Autowired
	private StepService service;

	@GetMapping
	public Collection<Step> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Step findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Step create(@Valid @RequestBody Step resource) {
		return service.create(resource);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Step create(@Valid @RequestBody Step resource, @PathVariable Integer id) {
		return service.update(resource, id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
