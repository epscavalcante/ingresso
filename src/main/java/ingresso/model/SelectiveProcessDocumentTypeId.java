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

}
