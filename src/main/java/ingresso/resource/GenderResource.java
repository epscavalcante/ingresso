package ingresso.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.Gender;
import ingresso.repository.GenderRepository;

@RestController
@RequestMapping("/genders")
public class GenderResource {

	@Autowired
	private GenderRepository repository;

	@GetMapping
	public Collection<Gender> findAll() {
		return repository.findAll();
	}

}
