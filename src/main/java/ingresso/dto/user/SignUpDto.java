package ingresso.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

public class SignUpDto {

	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String confirmEmail;

	@NotBlank
	private String password;

	@NotBlank
	private String confirmPassword;

	@CPF
	@NotBlank
	private String cpf;

	@NotNull
	private Integer selectiveProcessId;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getSelectiveProcessId() {
		return selectiveProcessId;
	}

	public void setSelectiveProcessId(Integer selectiveProcessId) {
		this.selectiveProcessId = selectiveProcessId;
	}

	public boolean emailsNotEqual() {
		return !email.equals(confirmEmail);
	}

	public boolean passwordsNotEqual() {
		return !password.equals(confirmPassword);
	}

}
