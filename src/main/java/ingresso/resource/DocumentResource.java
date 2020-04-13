package ingresso.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ingresso.dto.MessageDto;
import ingresso.dto.UploadDto;
import ingresso.model.DocumentFile;
import ingresso.service.DocumentService;

@RestController
@RequestMapping("/documents")
public class DocumentResource {

	@Autowired
	private DocumentService service;

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void upload(UploadDto dto) {
		service.create(dto);
	}

	@GetMapping("/{filename}")
	public ResponseEntity<Resource> download(@PathVariable String filename) {
		DocumentFile file = service.documentFile(filename);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf(file.getContentType()));
		headers.setContentLength(file.getContent().length);
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=".concat(file.getFilename()));

		ByteArrayResource resource = new ByteArrayResource(file.getContent());
		return ResponseEntity.ok().headers(headers).body(resource);
	}

	@DeleteMapping("/{filename}")
	public ResponseEntity<MessageDto> remove(@PathVariable String filename) {
		service.remove(filename);
		return ResponseEntity.ok(new MessageDto("Documento excluido."));
	}

}
