package ingresso.dto.authentication;

public class UserInfoDto {

	private String username;
	private String password;
	private Integer selectiveProcessId;

	public UserInfoDto() {
	}

	public UserInfoDto(String username, String password, Integer selectiveProcessId) {
		this.username = username;
		this.password = password;
		this.selectiveProcessId = selectiveProcessId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSelectiveProcessId() {
		return selectiveProcessId;
	}

	public void setSelectiveProcessId(Integer selectiveProcessId) {
		this.selectiveProcessId = selectiveProcessId;
	}

}
