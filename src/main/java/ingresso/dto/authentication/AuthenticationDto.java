package ingresso.dto.authentication;

import java.util.List;

import ingresso.model.User;

public class AuthenticationDto {

	private Integer candidateId;
	private String name;
	private List<String> roles;
	private String token;

	public AuthenticationDto(Integer candidateId, User user, String token) {
		this(candidateId, user.getName(), user.getRolesList(), token);
	}

	public AuthenticationDto(Integer candidateId, String name, List<String> roles, String token) {
		this.candidateId = candidateId;
		this.name = name;
		this.roles = roles;
		this.token = token;
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
