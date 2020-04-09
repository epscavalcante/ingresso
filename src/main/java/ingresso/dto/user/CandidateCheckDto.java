package ingresso.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

public class CandidateCheckDto {

	@NotBlank
	@CPF
	private String cpf;

	@NotBlank
	@Email
	private String email;

	@NotNull
	private Integer selectiveProcessId;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSelectiveProcessId() {
		return selectiveProcessId;
	}

	public void setSelectiveProcessId(Integer selectiveProcessId) {
		this.selectiveProcessId = selectiveProcessId;
	}

}
