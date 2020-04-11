package ingresso.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class ResourceUriHelper {

	public static String passwordResetUrl(String token) {
		return ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/password-reset/{token}")
				.buildAndExpand(token).toString();
	}

}
