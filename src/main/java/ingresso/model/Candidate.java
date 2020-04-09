package ingresso.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(optional = false, cascade = CascadeType.MERGE)
	private Person person;

	@ManyToOne(optional = false)
	private SelectiveProcess selectiveProcess;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CandidateStatus status;

	@OneToOne(optional = true, cascade = CascadeType.MERGE)
	private Job job;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public SelectiveProcess getSelectiveProcess() {
		return selectiveProcess;
	}

	public void setSelectiveProcess(SelectiveProcess selectiveProcess) {
		this.selectiveProcess = selectiveProcess;
	}

	public CandidateStatus getStatus() {
		return status;
	}

	public void setStatus(CandidateStatus status) {
		this.status = status;
	}

	public Job getJob() {
		if (Objects.isNull(job))
			setJob(new Job());
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public boolean forbiddenEnrollment() {
		return !this.getStatus().equals(CandidateStatus.REGISTERED);
	}

}
