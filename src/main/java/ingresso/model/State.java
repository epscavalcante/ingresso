package ingresso.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class State {

	@Id
	private Integer id;

	private String name;

	private String abbreviation;

	public State() {
	}

	public State(Integer id, String name, String abbreviation) {
		this.id = id;
		this.name = name;
		this.abbreviation = abbreviation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

}
