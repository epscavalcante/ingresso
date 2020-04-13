package ingresso.dto.password;

import javax.validation.constraints.NotBlank;

public class PasswordChangeDto {

	@NotBlank
	private String password;

	@NotBlank
	private String confirmPassword;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean passwordsNotEqual() {
		return !password.equals(confirmPassword);
	}

}
