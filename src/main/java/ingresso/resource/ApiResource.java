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
import org.springframework.web.bind.annotation.ResponseStatus;

import ingresso.service.ApiService;

public abstract class ApiResource<R, ID> {

	@Autowired
	private ApiService<R, ID> service;

	@GetMapping
	public Collection<R> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public R findById(@PathVariable ID id) {
		return service.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public R create(@Valid @RequestBody R resource) {
		return service.create(resource);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public R create(@Valid @RequestBody R resource, @PathVariable ID id) {
		return service.update(resource, id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)	
	public void delete(@PathVariable ID id) {
		service.delete(id);
	}
}
