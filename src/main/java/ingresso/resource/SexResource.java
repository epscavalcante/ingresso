package ingresso.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.Sex;
import ingresso.repository.SexRepository;

@RestController
@RequestMapping("/sexes")
public class SexResource {

	@Autowired
	private SexRepository repository;

	@GetMapping
	public Collection<Sex> findAll() {
		return repository.findAll();
	}

}
