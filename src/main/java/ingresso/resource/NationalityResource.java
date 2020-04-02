package ingresso.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.Nationality;
import ingresso.repository.NationalityRepository;

@RestController
@RequestMapping("/nationalities")
public class NationalityResource {

	@Autowired
	private NationalityRepository repository;

	@GetMapping
	public Collection<Nationality> findAll() {
		return repository.findAll();
	}

}
