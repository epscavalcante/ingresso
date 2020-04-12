package ingresso.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ingresso.dto.password.PasswordRecoveryDto;
import ingresso.dto.password.PasswordResetDto;
import ingresso.event.PasswordRecoveryEventPublisher;
import ingresso.exception.AppException;
import ingresso.model.PasswordResetToken;
import ingresso.model.User;
import ingresso.repository.PasswordResetTokenRepository;
import ingresso.repository.UserRepository;
import ingresso.utils.ResourceUriHelper;

@Service
public class PasswordService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;

	@Autowired
	private PasswordRecoveryEventPublisher eventPublisher;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public void passwordRecovery(PasswordRecoveryDto passwordRecoveryDto) {
		Optional<User> optionalUser = userRepository.findByEmail(passwordRecoveryDto.getEmail());
		if (optionalUser.isEmpty()) {
			throw new AppException("E-mail ".concat(passwordRecoveryDto.getEmail())
					.concat(" não encontrado!<br>Já efetuou seu registro em <strong>Primeiro Acesso</strong> ?"));
		}
		PasswordResetToken passwordResetToken = new PasswordResetToken(UUID.randomUUID().toString(),
				optionalUser.get());
		passwordResetTokenRepository.save(passwordResetToken);

		String url = ResourceUriHelper.passwordResetUrl(passwordResetToken.getToken());
		passwordResetToken.setUrl(url);
		eventPublisher.publishEvent(passwordResetToken);
	}

	@Transactional
	public void passwordReset(PasswordResetDto passwordResetDto) {
		if (passwordResetDto.passwordsNotEqual()) {
			throw new AppException("Senhas devem ser iguais!");
		}
		Optional<PasswordResetToken> optional = passwordResetTokenRepository.findByToken(passwordResetDto.getToken());
		if (optional.isEmpty()) {
			throw new AppException("Token INVÁLIDO! Volte na tela de login e clique no link => Esqueceu a senha?");
		}
		if (optional.get().getExpiresIn().isBefore(LocalDateTime.now())) {
			throw new AppException("Token EXPIRADO! Volte na tela de login e clique no link => Esqueceu a senha?");
		}
		User user = optional.get().getUser();
		user.setPassword(passwordEncoder.encode(passwordResetDto.getPassword()));
		userRepository.save(user);
	}

}
