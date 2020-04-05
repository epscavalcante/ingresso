package ingresso.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.dto.EnrollmentDto;
import ingresso.model.Candidate;
import ingresso.repository.CandidateRepository;

@Service
public class EnrollmentService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CandidateRepository candidateRepository;

	public EnrollmentDto findById(Integer id) {
		return build(candidateRepository.findById(id).get());
	}

	@Transactional
	public EnrollmentDto save(Integer candidateId, EnrollmentDto dto) {
		Candidate candidate = candidateRepository.findById(candidateId).get();
		modelMapper.map(dto, candidate.getPerson());
		modelMapper.map(dto.getJob(), candidate.getJob());
		candidateRepository.save(candidate);
		return build(candidate);
	}

	private EnrollmentDto build(Candidate candidate) {
		EnrollmentDto enrollmentDto = new EnrollmentDto();
		modelMapper.map(candidate.getPerson(), enrollmentDto);
		modelMapper.map(candidate.getJob(), enrollmentDto.getJob());
		return enrollmentDto;
	}

}
