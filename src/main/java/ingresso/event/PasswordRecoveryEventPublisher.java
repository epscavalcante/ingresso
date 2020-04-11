package ingresso.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import ingresso.model.PasswordResetToken;

@Component
public class PasswordRecoveryEventPublisher {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Async("threadPoolTaskExecutor")
	public void publishEvent(PasswordResetToken passwordResetToken) {
		PasswordRecoveryEvent passwordRecoveryEvent = new PasswordRecoveryEvent(this, passwordResetToken);
		applicationEventPublisher.publishEvent(passwordRecoveryEvent);
	}

}
