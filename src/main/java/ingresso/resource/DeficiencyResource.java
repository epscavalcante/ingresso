package ingresso.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.Deficiency;
import ingresso.repository.DeficiencyRepository;

@RestController
@RequestMapping("/deficiencies")
public class DeficiencyResource {

	@Autowired
	private DeficiencyRepository repository;

	@GetMapping
	public Collection<Deficiency> findAll() {
		return repository.findAll();
	}

}
