package ingresso.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class SelectiveProcessDocumentType {

	@EmbeddedId
	private SelectiveProcessDocumentTypeId id;

	@NotNull
	@MapsId("selectiveProcessId")
	@ManyToOne(optional = false)
	@JoinColumn(name = "selective_process_id", nullable = false)
	private SelectiveProcess selectiveProcess;

	@NotNull
	@MapsId("documentTypeId")
	@ManyToOne(optional = false)
	@JoinColumn(name = "document_type_id", nullable = false)
	private DocumentType documentType;

	@NotNull
	@Min(0)
	private Double points;

	@NotNull
	private Boolean mandatory;

	public SelectiveProcessDocumentTypeId getId() {
		return id;
	}

	public void setId(SelectiveProcessDocumentTypeId id) {
		this.id = id;
	}

	public SelectiveProcess getSelectiveProcess() {
		return selectiveProcess;
	}

	public void setSelectiveProcess(SelectiveProcess selectiveProcess) {
		this.selectiveProcess = selectiveProcess;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
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
