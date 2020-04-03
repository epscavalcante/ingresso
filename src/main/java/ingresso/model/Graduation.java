package ingresso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Graduation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String institutionName;

	@ManyToOne
	private SuperiorCourse superiorCourse;

	private Integer conclusionYear;

	@ManyToOne
	private City city;

	@ManyToOne
	private InstitutionType institutionType;

	@ManyToOne
	private Modality modality;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public SuperiorCourse getSuperiorCourse() {
		return superiorCourse;
	}

	public void setSuperiorCourse(SuperiorCourse superiorCourse) {
		this.superiorCourse = superiorCourse;
	}

	public Integer getConclusionYear() {
		return conclusionYear;
	}

	public void setConclusionYear(Integer conclusionYear) {
		this.conclusionYear = conclusionYear;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public InstitutionType getInstitutionType() {
		return institutionType;
	}

	public void setInstitutionType(InstitutionType institutionType) {
		this.institutionType = institutionType;
	}

	public Modality getModality() {
		return modality;
	}

	public void setModality(Modality modality) {
		this.modality = modality;
	}

}
