package ingresso.dto;

import java.util.List;

public class CandidateDocumentDto {

	private DocumentTypeDto documentType;
	private List<String> filenames;

	public CandidateDocumentDto(DocumentTypeDto documentType) {
		this.documentType = documentType;
	}

	public DocumentTypeDto getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentTypeDto documentType) {
		this.documentType = documentType;
	}

	public List<String> getFilenames() {
		return filenames;
	}

	public void setFilenames(List<String> filenames) {
		this.filenames = filenames;
	}

}
