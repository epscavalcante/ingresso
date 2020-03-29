package ingresso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(optional = false)
	private Person person;

	@ManyToOne(optional = false)
	private SelectiveProcess selectiveProcess;

	@ManyToOne(optional = false)
	private CandidateStatus status;

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

}
