package ingresso.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class AppEmailSender {

	@Autowired
	private JavaMailSender javaMailSender;

	public void send(AppEmailMessage message) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		simpleMailMessage.setFrom(message.getFrom());
		simpleMailMessage.setTo(message.getTo().toArray(new String[message.getTo().size()]));
		simpleMailMessage.setSubject(message.getSubject());
		simpleMailMessage.setText(message.getBody());

		javaMailSender.send(simpleMailMessage);
	}

}
