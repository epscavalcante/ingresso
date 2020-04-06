package ingresso.dto;

public class GraduationDto {

	private String institutionName;
	private SuperiorCourseDto superiorCourse;
	private Integer conclusionYear;
	private CityDto city;
	private InstitutionTypeDto institutionType;
	private ModalityDto modality;

	public GraduationDto() {
		this.superiorCourse = new SuperiorCourseDto();
		this.city = new CityDto();
		this.institutionType = new InstitutionTypeDto();
		this.modality = new ModalityDto();
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public SuperiorCourseDto getSuperiorCourse() {
		return superiorCourse;
	}

	public void setSuperiorCourse(SuperiorCourseDto superiorCourse) {
		this.superiorCourse = superiorCourse;
	}

	public Integer getConclusionYear() {
		return conclusionYear;
	}

	public void setConclusionYear(Integer conclusionYear) {
		this.conclusionYear = conclusionYear;
	}

	public CityDto getCity() {
		return city;
	}

	public void setCity(CityDto city) {
		this.city = city;
	}

	public InstitutionTypeDto getInstitutionType() {
		return institutionType;
	}

	public void setInstitutionType(InstitutionTypeDto institutionType) {
		this.institutionType = institutionType;
	}

	public ModalityDto getModality() {
		return modality;
	}

	public void setModality(ModalityDto modality) {
		this.modality = modality;
	}

}
