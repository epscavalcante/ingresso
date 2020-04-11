package ingresso.email;

import java.util.List;

public class AppEmailMessage {

	private String from;

	private List<String> to;

	private String subject;

	private String body;

	public AppEmailMessage(String from, List<String> to, String subject, String body) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

	public String getFrom() {
		return from;
	}

	public List<String> getTo() {
		return to;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}

}
