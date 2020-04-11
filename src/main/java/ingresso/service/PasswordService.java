package ingresso.service;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.dto.password.PasswordRecoveryDto;
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

		String url = ResourceUriHelper.gerarUrlRecuperarSenha(passwordResetToken.getToken());
		passwordResetToken.setUrl(url);
		eventPublisher.publishEvent(passwordResetToken);
	}

}
