package ingresso.dto.authentication;

import java.util.List;

import ingresso.model.User;

public class AuthenticationDto {

	private Integer userId;
	private Integer candidateId;
	private String name;
	private List<String> roles;
	private String token;

	public AuthenticationDto(Integer candidateId, User user, String token) {
		this.userId = user.getId();
		this.candidateId = candidateId;
		this.name = user.getName();
		this.roles = user.getRolesList();
		this.token = token;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public String getName() {
		return name;
	}

	public List<String> getRoles() {
		return roles;
	}

	public String getToken() {
		return token;
	}

}
