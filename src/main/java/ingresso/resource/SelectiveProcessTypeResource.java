package ingresso.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.SelectiveProcessType;
import ingresso.repository.SelectiveProcessTypeRepository;

@RestController
@RequestMapping("/selective-process-types")
public class SelectiveProcessTypeResource {

	@Autowired
	private SelectiveProcessTypeRepository repository;

	@GetMapping
	public Collection<SelectiveProcessType> findAll() {
		return repository.findAll();
	}

}
