package ingresso.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.Bank;
import ingresso.repository.BankRepository;

@RestController
@RequestMapping("/banks")
public class BankResource {

	@Autowired
	private BankRepository repository;

	@GetMapping
	public Collection<Bank> findAll() {
		return repository.findAll();
	}

}
