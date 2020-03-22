package ingresso.model;

public enum CandidateStatus {

	ENROLLED("Inscrito"), PRE_MATRICULATION("Pré-Matrículado"), CLASSIFIED("Classificado"), APPROVED("Aprovado");

	private String description;

	private CandidateStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
