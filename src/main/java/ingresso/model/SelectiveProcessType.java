package ingresso.model;

public enum SelectiveProcessType {

	GRADUATION("Graduação"), POST_GRADUATION("Pós-Graduação");

	private String description;

	private SelectiveProcessType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
