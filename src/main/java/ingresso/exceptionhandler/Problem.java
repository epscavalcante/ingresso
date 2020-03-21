package ingresso.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

public class Problem {

	private String message;
	private Integer status;
	private OffsetDateTime timestamp;
	private List<Field> fields;

	public Problem(String message, Integer status, OffsetDateTime timestamp, List<Field> fields) {
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
		this.fields = fields;
	}

	public String getMessage() {
		return message;
	}

	public Integer getStatus() {
		return status;
	}

	public OffsetDateTime getTimestamp() {
		return timestamp;
	}

	public List<Field> getFields() {
		return fields;
	}

	public static class Field {
		private String name;
		private String message;

		public Field(String name, String message) {
			this.name = name;
			this.message = message;
		}

		public String getName() {
			return name;
		}

		public String getMessage() {
			return message;
		}
	}
}
