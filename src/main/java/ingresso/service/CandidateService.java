package ingresso.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.dto.CandidateDocumentDto;
import ingresso.dto.DocumentTypeDto;
import ingresso.model.Candidate;
import ingresso.model.Document;
import ingresso.repository.CandidateRepository;
import ingresso.repository.DocumentRepository;
import ingresso.repository.SelectiveProcessDocumentTypeRepository;

@Service
public class CandidateService {

	@Autowired
	private CandidateRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private SelectiveProcessDocumentTypeRepository selectiveProcessDocumentTypeRepository;

	@Autowired
	private DocumentRepository documentRepository;

	public Integer findCandidateId(Integer selectiveProcessId) {
		return repository.findBySelectiveProcessId(selectiveProcessId).orElse(new Candidate()).getId();
	}

	public Collection<CandidateDocumentDto> findDocuments(Integer candidateId) {
		Candidate candidate = repository.findById(candidateId).get();

		List<CandidateDocumentDto> result = selectiveProcessDocumentTypeRepository
				.findBySelectiveProcess(candidate.getSelectiveProcess()).stream()
				.map(spdt -> new CandidateDocumentDto(modelMapper.map(spdt.getDocumentType(), DocumentTypeDto.class)))
				.collect(Collectors.toList());

		List<Document> documents = documentRepository.findByCandidate(candidate);
		for (CandidateDocumentDto candidateDocumentDto : result) {
			List<String> filenames = documents.stream()
					.filter(d -> d.getType().getId().equals(candidateDocumentDto.getDocumentType().getId()))
					.map(d -> d.getFile().getFilename()).collect(Collectors.toList());
			candidateDocumentDto.setFilenames(filenames);
		}

		return result;
	}

}
