package ingresso.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.Modality;
import ingresso.repository.ModalityRepository;

@RestController
@RequestMapping("/modalities")
public class ModalityResource {

	@Autowired
	private ModalityRepository repository;

	@GetMapping
	public Collection<Modality> findAll() {
		return repository.findAll();
	}

}
