package ingresso.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ingresso.dto.MessageDto;
import ingresso.dto.password.PasswordRecoveryDto;
import ingresso.dto.password.PasswordResetDto;
import ingresso.service.PasswordService;

@RestController
public class PasswordResource {

	@Autowired
	private PasswordService service;

	@PostMapping("/password-recovery")
	public ResponseEntity<MessageDto> passwordRecovery(@Valid @RequestBody PasswordRecoveryDto passwordRecoveryDto) {
		service.passwordRecovery(passwordRecoveryDto);
		return ResponseEntity.ok(new MessageDto("Em alguns minutos acesse o seu e-mail para atualizar sua senha."));
	}

	@GetMapping("/password-reset/{token}")
	public ResponseEntity<PasswordResetDto> passwordReset(@PathVariable String token) {
		PasswordResetDto passwordResetDto = new PasswordResetDto();
		passwordResetDto.setToken(token);
		return ResponseEntity.ok(passwordResetDto);
	}

	@PostMapping("/password-reset")
	public ResponseEntity<MessageDto> passwordReset(@Valid @RequestBody PasswordResetDto passwordResetDto) {
		service.passwordReset(passwordResetDto);
		return ResponseEntity.ok(new MessageDto("Senha atualizada, acesse o sistema efetuando o login."));
	}

}
