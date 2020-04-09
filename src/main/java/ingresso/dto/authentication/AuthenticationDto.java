package ingresso.dto.authentication;

import java.util.List;

import ingresso.model.User;

public class AuthenticationDto {

	private String username;
	private List<String> roles;
	private String token;

	public AuthenticationDto(User user, String token) {
		this(user.getUsername(), user.getRolesList(), token);
	}

	public AuthenticationDto(String username, List<String> roles, String token) {
		this.username = username;
		this.roles = roles;
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
