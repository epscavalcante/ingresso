package ingresso.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.dto.signup.CandidateCheckDto;
import ingresso.service.SignUpService;

@RestController
@RequestMapping("/signups")
public class SignUpResource {

	@Autowired
	private SignUpService service;

	@PostMapping("/check")
	public void check(@Valid @RequestBody CandidateCheckDto candidateCheckDto) {
		service.check(candidateCheckDto);
	}

}
