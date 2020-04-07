package ingresso.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadDto {

	private MultipartFile file;
	private Integer candidateId;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

}
