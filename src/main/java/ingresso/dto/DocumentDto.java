package ingresso.dto;

public class DocumentDto {

	private Integer candidateId;
	private String filename;

	public DocumentDto(Integer candidateId, String filename) {
		this.candidateId = candidateId;
		this.filename = filename;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
