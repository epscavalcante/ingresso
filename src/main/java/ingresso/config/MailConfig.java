package ingresso.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("classpath:env/mail.properties")
public class MailConfig {

	@Autowired
	private Environment env;

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost(env.getProperty("mail.smtp.host"));
		mailSender.setPort(env.getProperty("mail.smtp.port", Integer.class));
		mailSender.setUsername(env.getProperty("mail.smtp.username"));
		mailSender.setPassword(env.getProperty("mail.smtp.password"));

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", env.getProperty("mail.smtp.port"));
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "true");

		return mailSender;
	}

}
