package ingresso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String localName;

	@ManyToOne
	private City city;

	private Long socialIdentificationNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Long getSocialIdentificationNumber() {
		return socialIdentificationNumber;
	}

	public void setSocialIdentificationNumber(Long socialIdentificationNumber) {
		this.socialIdentificationNumber = socialIdentificationNumber;
	}

}
