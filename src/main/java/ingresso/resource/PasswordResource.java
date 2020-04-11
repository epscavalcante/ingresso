package ingresso.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ingresso.dto.MessageDto;
import ingresso.dto.password.PasswordRecoveryDto;
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

}
