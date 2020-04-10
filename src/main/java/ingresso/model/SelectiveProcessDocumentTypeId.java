package ingresso.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SelectiveProcessDocumentTypeId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "selective_process_id")
	private Integer selectiveProcessId;

	@Column(name = "document_type_id")
	private Integer documentTypeId;

	public SelectiveProcessDocumentTypeId() {
	}

	public SelectiveProcessDocumentTypeId(Integer selectiveProcessId, Integer documentTypeId) {
		this.selectiveProcessId = selectiveProcessId;
		this.documentTypeId = documentTypeId;
	}

	public Integer getSelectiveProcessId() {
		return selectiveProcessId;
	}

	public void setSelectiveProcessId(Integer selectiveProcessId) {
		this.selectiveProcessId = selectiveProcessId;
	}

	public Integer getDocumentTypeId() {
		return documentTypeId;
	}

	public void setDocumentTypeId(Integer documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentTypeId == null) ? 0 : documentTypeId.hashCode());
		result = prime * result + ((selectiveProcessId == null) ? 0 : selectiveProcessId.hashCode());
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
		SelectiveProcessDocumentTypeId other = (SelectiveProcessDocumentTypeId) obj;
		if (documentTypeId == null) {
			if (other.documentTypeId != null)
				return false;
		} else if (!documentTypeId.equals(other.documentTypeId))
			return false;
		if (selectiveProcessId == null) {
			if (other.selectiveProcessId != null)
				return false;
		} else if (!selectiveProcessId.equals(other.selectiveProcessId))
			return false;
		return true;
	}

}
