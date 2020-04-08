package ingresso.service;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.dto.UploadDto;
import ingresso.model.Document;
import ingresso.model.DocumentFile;
import ingresso.repository.DocumentFileRepository;
import ingresso.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository repository;

	@Autowired
	private DocumentFileRepository documentFileRepository;

	@Transactional
	public void create(UploadDto dto) {
		if (dto.getFile().isEmpty()) {
			throw new RuntimeException("Selecione o Arquivo!");
		}
		Document document = new Document();
		document.getCandidate().setId(dto.getCandidateId());
		document.getType().setId(dto.getDocumentTypeId());
		try {
			document.getFile().setContent(dto.getFile().getBytes());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		String extension = ".".concat(getExtension(dto.getFile().getOriginalFilename()));
		document.getFile().setFilename(UUID.randomUUID().toString().concat(extension));
		document.getFile().setContentType(dto.getFile().getContentType());

		repository.save(document);
	}

	public DocumentFile documentFile(String filename) {
		return documentFileRepository.findByFilename(filename).get();
	}

	private String getExtension(String filename) {
		Optional<String> optional = Optional.ofNullable(filename).filter(f -> f.contains("."))
				.map(f -> f.substring(filename.lastIndexOf(".") + 1));
		return optional.isPresent() ? optional.get() : "";
	}

}
