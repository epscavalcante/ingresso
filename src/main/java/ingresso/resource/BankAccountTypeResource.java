package ingresso.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.BankAccountType;
import ingresso.repository.BankAccountTypeRepository;

@RestController
@RequestMapping("/bank-account-types")
public class BankAccountTypeResource {

	@Autowired
	private BankAccountTypeRepository repository;

	@GetMapping
	public Collection<BankAccountType> findAll() {
		return repository.findAll();
	}

}
