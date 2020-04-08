package ingresso.model;

import java.time.LocalDateTime;

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

	@ManyToOne
	private Candidate candidate;

	@ManyToOne(optional = false)
	private DocumentType type;

	@OneToOne(optional = false, cascade = CascadeType.PERSIST)
	private DocumentFile file;

	private Boolean homologated;

	private LocalDateTime homologatedAt;

	private Double points;

	public Document() {
		this.candidate = new Candidate();
		this.type = new DocumentType();
		this.file = new DocumentFile();
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

	public Boolean getHomologated() {
		return homologated;
	}

	public void setHomologated(Boolean homologated) {
		this.homologated = homologated;
	}

	public LocalDateTime getHomologatedAt() {
		return homologatedAt;
	}

	public void setHomologatedAt(LocalDateTime homologatedAt) {
		this.homologatedAt = homologatedAt;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

}
