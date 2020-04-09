package ingresso.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String cpf;

	private String email;

	private LocalDate birth;

	private String mother;

	@ManyToOne
	private Sex sex;

	@OneToOne(cascade = CascadeType.MERGE)
	private GeneralRegistry generalRegistry;

	private Integer children;

	@ManyToOne
	private CivilState civilState;

	@ManyToOne
	private Nationality nationality;

	@ManyToOne
	private City naturality;

	@ManyToOne
	private Deficiency deficiency;

	@ManyToOne
	private Race race;

	private Integer familyQuantity;

	@ManyToOne
	private Gender gender;

	private String socialName;

	@OneToOne(cascade = CascadeType.MERGE)
	private BankAccount bankAccount;

	@OneToOne(cascade = CascadeType.MERGE)
	private Graduation graduation;

	@OneToOne(cascade = CascadeType.MERGE)
	private Address address;

	private String phoneOne;

	private String phoneTwo;

	@PrePersist
	void prePersiste() {
		setCpf(getCpf().replaceAll("[^0-9+]", ""));
	}

	@PreUpdate
	void preUpdate() {
		setCpf(getCpf().replaceAll("[^0-9+]", ""));
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public GeneralRegistry getGeneralRegistry() {
		return generalRegistry;
	}

	public void setGeneralRegistry(GeneralRegistry generalRegistry) {
		this.generalRegistry = generalRegistry;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public CivilState getCivilState() {
		return civilState;
	}

	public void setCivilState(CivilState civilState) {
		this.civilState = civilState;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public City getNaturality() {
		return naturality;
	}

	public void setNaturality(City naturality) {
		this.naturality = naturality;
	}

	public Deficiency getDeficiency() {
		return deficiency;
	}

	public void setDeficiency(Deficiency deficiency) {
		this.deficiency = deficiency;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Integer getFamilyQuantity() {
		return familyQuantity;
	}

	public void setFamilyQuantity(Integer familyQuantity) {
		this.familyQuantity = familyQuantity;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getSocialName() {
		return socialName;
	}

	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Graduation getGraduation() {
		return graduation;
	}

	public void setGraduation(Graduation graduation) {
		this.graduation = graduation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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

}
