package ingresso.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class PasswordResetToken {

	private static final int EXPIRY_IN_MINUTES = 30;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String token;

	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private User user;

	private LocalDateTime expiresIn;

	@Transient
	private String url;

	public PasswordResetToken() {
	}

	public PasswordResetToken(final String token, final User user) {
		this.token = token;
		this.user = user;
		this.expiresIn = LocalDateTime.now().plusMinutes(EXPIRY_IN_MINUTES);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(LocalDateTime expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
