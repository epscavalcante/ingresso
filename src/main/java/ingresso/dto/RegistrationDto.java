package ingresso.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RegistrationDto {

	private Integer id;

	private String name;

	private String cpf;

	@NotNull
	private LocalDate birth;

	@NotBlank
	private String mother;

	@NotNull
	private Integer sexId;

	private GeneralRegistryDto generalRegistry;

	private Integer children;

	private Integer civilStateId;

	private Integer nationalityId;

	private Integer naturalityId;

	private Integer deficiencyId;

	private Integer raceId;

	private Integer familyQuantity;

	private Integer genderId;

	private String socialName;

	private BankAccountDto bankAccount;

	private GraduationDto graduation;

	private AddressDto address;

	private String phoneOne;
	private String phoneTwo;

	private JobDto job;

	public RegistrationDto() {
		this.job = new JobDto();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public Integer getSexId() {
		return sexId;
	}

	public void setSexId(Integer sexId) {
		this.sexId = sexId;
	}

	public GeneralRegistryDto getGeneralRegistry() {
		return generalRegistry;
	}

	public void setGeneralRegistry(GeneralRegistryDto generalRegistry) {
		this.generalRegistry = generalRegistry;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public Integer getCivilStateId() {
		return civilStateId;
	}

	public void setCivilStateId(Integer civilStateId) {
		this.civilStateId = civilStateId;
	}

	public Integer getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(Integer nationalityId) {
		this.nationalityId = nationalityId;
	}

	public Integer getNaturalityId() {
		return naturalityId;
	}

	public void setNaturalityId(Integer naturalityId) {
		this.naturalityId = naturalityId;
	}

	public Integer getDeficiencyId() {
		return deficiencyId;
	}

	public void setDeficiencyId(Integer deficiencyId) {
		this.deficiencyId = deficiencyId;
	}

	public Integer getRaceId() {
		return raceId;
	}

	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}

	public Integer getFamilyQuantity() {
		return familyQuantity;
	}

	public void setFamilyQuantity(Integer familyQuantity) {
		this.familyQuantity = familyQuantity;
	}

	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}

	public String getSocialName() {
		return socialName;
	}

	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}

	public BankAccountDto getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccountDto bankAccount) {
		this.bankAccount = bankAccount;
	}

	public GraduationDto getGraduation() {
		return graduation;
	}

	public void setGraduation(GraduationDto graduation) {
		this.graduation = graduation;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public String getPhoneOne() {
		return phoneOne;
	}

	public void setPhoneOne(String phoneOne) {
		this.phoneOne = phoneOne;
	}

	public String getPhoneTwo() {
		return phoneTwo;
	}

	public void setPhoneTwo(String phoneTwo) {
		this.phoneTwo = phoneTwo;
	}

	public JobDto getJob() {
		return job;
	}

	public void setJob(JobDto job) {
		this.job = job;
	}

}
