package ingresso.resource;

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
import ingresso.model.User;

@RestController
@RequestMapping("/auth")
public class AuthenticationResource {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenManager jwtTokenManager;

	@PostMapping
	public ResponseEntity<AuthenticationDto> authenticate(@RequestBody UserInfoDto login) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				login.getUsername(), login.getPassword());
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		User user = (User) authentication.getPrincipal();
		String jwt = jwtTokenManager.generateToken(user);
		AuthenticationDto tokenResponse = new AuthenticationDto(user, jwt);
		return ResponseEntity.ok(tokenResponse);
	}

}
