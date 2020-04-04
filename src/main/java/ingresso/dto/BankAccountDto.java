package ingresso.dto;

public class BankAccountDto {

	private BankDto bank;
	private BankAccountTypeDto type;
	private String agency;
	private String number;

	public BankDto getBank() {
		return bank;
	}

	public void setBank(BankDto bank) {
		this.bank = bank;
	}

	public BankAccountTypeDto getType() {
		return type;
	}

	public void setType(BankAccountTypeDto type) {
		this.type = type;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
