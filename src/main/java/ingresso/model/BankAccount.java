package ingresso.model;

import javax.persistence.OneToOne;

public class BankAccount {

	@OneToOne
	private Bank bank;

	@OneToOne
	private BankType bankType;

	private String agency;

	private String number;

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public BankType getBankType() {
		return bankType;
	}

	public void setBankType(BankType bankType) {
		this.bankType = bankType;
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
