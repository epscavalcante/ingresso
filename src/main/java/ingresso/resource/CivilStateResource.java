package ingresso.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.CivilState;
import ingresso.repository.CivilStateRepository;

@RestController
@RequestMapping("/civil-states")
public class CivilStateResource {

	@Autowired
	private CivilStateRepository repository;

	@GetMapping
	public Collection<CivilState> findAll() {
		return repository.findAll();
	}

}
