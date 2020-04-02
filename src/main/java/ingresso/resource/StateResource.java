package ingresso.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.City;
import ingresso.model.State;
import ingresso.repository.CityRepository;
import ingresso.repository.StateRepository;

@RestController
@RequestMapping("/states")
public class StateResource {

	@Autowired
	private StateRepository repository;

	@Autowired
	private CityRepository cityRepository;

	@GetMapping
	public Collection<State> findAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}/cities")
	public Collection<City> findByState(@PathVariable Integer id) {
		return cityRepository.findByStateId(id);
	}

}
