package ingresso.dto;

public class SelectiveProcessDocumentTypeDto {

	private DocumentTypeDto documentType;
	private Double points;
	private Boolean mandatory;

	public DocumentTypeDto getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentTypeDto documentType) {
		this.documentType = documentType;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public Boolean getMandatory() {
		return mandatory;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

}
