package ingresso.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.Step;
import ingresso.repository.StepRepository;

@RestController
@RequestMapping("/steps")
public class StepResource extends ApiResource<Step, Integer> {

	public StepResource(StepRepository repository) {
		super(repository);
	}

}
