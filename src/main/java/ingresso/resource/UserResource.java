package ingresso.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.authentication.JwtTokenManager;
import ingresso.dto.authentication.AuthenticationDto;
import ingresso.dto.authentication.UserInfoDto;
import ingresso.dto.user.CandidateCheckDto;
import ingresso.dto.user.SignUpDto;
import ingresso.model.User;
import ingresso.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService service;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenManager jwtTokenManager;

	@PostMapping("/check")
	public SignUpDto check(@Valid @RequestBody CandidateCheckDto candidateCheckDto) {
		return service.check(candidateCheckDto);
	}

	@PostMapping
	public ResponseEntity<AuthenticationDto> signUp(@Valid @RequestBody SignUpDto signUpDto) {
		UserInfoDto userInfoDto = service.create(signUpDto);

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				userInfoDto.getUsername(), userInfoDto.getPassword());
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		User user = (User) authentication.getPrincipal();
		String jwt = jwtTokenManager.generateToken(user);
		AuthenticationDto tokenResponse = new AuthenticationDto(user, jwt);
		return ResponseEntity.ok(tokenResponse);
	}

}
