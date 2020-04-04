package ingresso.dto;

public class JobDto {

	private String localName;
	private CityDto city;
	private Long socialIdentificationNumber;

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public CityDto getCity() {
		return city;
	}

	public void setCity(CityDto city) {
		this.city = city;
	}

	public Long getSocialIdentificationNumber() {
		return socialIdentificationNumber;
	}

	public void setSocialIdentificationNumber(Long socialIdentificationNumber) {
		this.socialIdentificationNumber = socialIdentificationNumber;
	}

}
