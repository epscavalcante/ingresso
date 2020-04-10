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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SelectiveProcessDocumentType other = (SelectiveProcessDocumentType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
