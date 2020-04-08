package ingresso.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(optional = false)
	private Candidate candidate;

	@ManyToOne(optional = false)
	private DocumentType type;

	@OneToOne(optional = false, cascade = CascadeType.PERSIST)
	private DocumentFile file;

	public Document() {
		this.candidate = new Candidate();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public DocumentType getType() {
		return type;
	}

	public void setType(DocumentType type) {
		this.type = type;
	}

	public DocumentFile getFile() {
		return file;
	}

	public void setFile(DocumentFile file) {
		this.file = file;
	}

}
