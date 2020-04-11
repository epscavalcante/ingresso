package ingresso.event;

import org.springframework.context.ApplicationEvent;

import ingresso.model.PasswordResetToken;

public class PasswordRecoveryEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private PasswordResetToken passwordResetToken;

	public PasswordRecoveryEvent(Object source, PasswordResetToken passwordResetToken) {
		super(source);
		this.passwordResetToken = passwordResetToken;
	}

	public PasswordResetToken getPasswordResetToken() {
		return passwordResetToken;
	}

}
