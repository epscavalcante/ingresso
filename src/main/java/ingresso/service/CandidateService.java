package ingresso.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.dto.CandidateDocumentDto;
import ingresso.dto.DocumentTypeDto;
import ingresso.model.Document;
import ingresso.repository.DocumentRepository;
import ingresso.repository.SelectiveProcessDocumentTypeRepository;

@Service
public class CandidateService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private SelectiveProcessDocumentTypeRepository selectiveProcessDocumentTypeRepository;

	@Autowired
	private DocumentRepository documentRepository;

	public Collection<CandidateDocumentDto> findDocuments(Integer candidateId) {
		Integer selectiveProcessId = 2; // TODO hardcode

		List<CandidateDocumentDto> result = selectiveProcessDocumentTypeRepository
				.findBySelectiveProcessId(selectiveProcessId).stream()
				.map(spdt -> new CandidateDocumentDto(modelMapper.map(spdt.getDocumentType(), DocumentTypeDto.class)))
				.collect(Collectors.toList());

		List<Document> documents = documentRepository.findByCandidateId(candidateId);
		for (CandidateDocumentDto candidateDocumentDto : result) {
			List<String> filenames = documents.stream()
					.filter(d -> d.getType().getId().equals(candidateDocumentDto.getDocumentType().getId()))
					.map(d -> d.getFile().getFilename()).collect(Collectors.toList());
			candidateDocumentDto.setFilenames(filenames);
		}

		return result;
	}

}
