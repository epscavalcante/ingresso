package ingresso.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import ingresso.email.AppEmailSender;
import ingresso.email.AppEmailMessage;
import ingresso.model.PasswordResetToken;

@Component
public class PasswordRecoveryEventListener implements ApplicationListener<PasswordRecoveryEvent> {

	@Autowired
	private Environment env;

	@Autowired
	private AppEmailSender emailSender;

	@Override
	public void onApplicationEvent(PasswordRecoveryEvent event) {
		PasswordResetToken passwordResetToken = event.getPasswordResetToken();
		String body = "Clique no endereço abaixo para Atualizar a sua senha!\r\n".concat(passwordResetToken.getUrl());

		AppEmailMessage mailMessage = new AppEmailMessage(env.getProperty("mail.smtp.username"),
				List.of(passwordResetToken.getUser().getEmail()), "Atualize a sua Senha", body);
		emailSender.send(mailMessage);
	}

}
