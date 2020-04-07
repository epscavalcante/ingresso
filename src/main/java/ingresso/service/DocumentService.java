package ingresso.service;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.dto.DocumentDto;
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

	public Collection<DocumentDto> findAll() {
		return repository.findAll().stream()
				.map(d -> new DocumentDto(d.getCandidate().getId(), d.getFile().getFilename()))
				.collect(Collectors.toList());
	}

	@Transactional
	public void create(UploadDto dto) {
		if (dto.getFile().isEmpty()) {
			throw new RuntimeException("Selecione o Arquivo!");
		}
		DocumentFile file = new DocumentFile();
		try {
			file.setContent(dto.getFile().getBytes());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		String extension = ".".concat(getExtension(dto.getFile().getOriginalFilename()));
		file.setFilename(UUID.randomUUID().toString().concat(extension));
		file.setContentType(dto.getFile().getContentType());

		Document document = new Document();
		document.getCandidate().setId(dto.getCandidateId());
		document.setFile(file);

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
