package ingresso.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.InstitutionType;
import ingresso.repository.InstitutionTypeRepository;

@RestController
@RequestMapping("/institution-types")
public class InstitutionTypeResource {

	@Autowired
	private InstitutionTypeRepository repository;

	@GetMapping
	public Collection<InstitutionType> findAll() {
		return repository.findAll();
	}

}
