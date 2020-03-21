package ingresso.dto;

public class SelectOptionDto {

	private String value;
	private String text;

	public SelectOptionDto(String value, String text) {
		this.value = value;
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public String getText() {
		return text;
	}

}
