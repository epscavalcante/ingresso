package ingresso.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.dto.CandidateDocumentDto;
import ingresso.service.CandidateService;

@RestController
@RequestMapping("/candidates")
public class CandidateResource {

	@Autowired
	private CandidateService service;

	@GetMapping("/{id}/documents")
	public Collection<CandidateDocumentDto> findDocuments(@PathVariable("id") Integer candidateId) {
		return service.findDocuments(candidateId);
	}

}
