package ingresso.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.Race;
import ingresso.repository.RaceRepository;

@RestController
@RequestMapping("/races")
public class RaceResource {

	@Autowired
	private RaceRepository repository;

	@GetMapping
	public Collection<Race> findAll() {
		return repository.findAll();
	}

}
