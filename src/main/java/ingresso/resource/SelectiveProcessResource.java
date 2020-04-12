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

import ingresso.model.SelectiveProcess;
import ingresso.service.SelectiveProcessService;

@RestController
@RequestMapping("/selective-processes")
public class SelectiveProcessResource {

	@Autowired
	private SelectiveProcessService service;

	@GetMapping
	public Collection<SelectiveProcess> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public SelectiveProcess findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SelectiveProcess create(@Valid @RequestBody SelectiveProcess resource) {
		return service.create(resource);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SelectiveProcess create(@Valid @RequestBody SelectiveProcess resource, @PathVariable Integer id) {
		return service.update(resource, id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

	@GetMapping("/open")
	public Collection<SelectiveProcess> findOpen() {
		return service.findOpen();
	}

}
