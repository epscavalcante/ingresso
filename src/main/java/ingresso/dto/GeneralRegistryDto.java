package ingresso.dto;

import java.time.LocalDate;

public class GeneralRegistryDto {

	private String number;
	private String consignorOrgan;
	private LocalDate consignedAt;
	private StateDto state;

	public GeneralRegistryDto() {
		this.state = new StateDto();
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

	public StateDto getState() {
		return state;
	}

	public void setState(StateDto state) {
		this.state = state;
	}

}
