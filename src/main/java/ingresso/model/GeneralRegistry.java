package ingresso.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GeneralRegistry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String number;

	private String consignorOrgan;

	private LocalDate consignedAt;

	@ManyToOne
	private State state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getConsignorOrgan() {
		return consignorOrgan;
	}

	public void setConsignorOrgan(String consignorOrgan) {
		this.consignorOrgan = consignorOrgan;
	}

	public LocalDate getConsignedAt() {
		return consignedAt;
	}

	public void setConsignedAt(LocalDate consignedAt) {
		this.consignedAt = consignedAt;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
