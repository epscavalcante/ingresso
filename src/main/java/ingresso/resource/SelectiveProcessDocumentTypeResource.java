package ingresso.resource;

import java.util.Collection;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.dto.SelectiveProcessDocumentTypeDto;
import ingresso.repository.SelectiveProcessDocumentTypeRepository;

@RestController
@RequestMapping("/selective-processes")
public class SelectiveProcessDocumentTypeResource {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private SelectiveProcessDocumentTypeRepository repository;

	@GetMapping("/{id}/document-types")
	public Collection<SelectiveProcessDocumentTypeDto> findDocumentTypes(
			@PathVariable("id") Integer selectiveProcessId) {
		return repository.findBySelectiveProcessId(selectiveProcessId).stream()
				.map(spdt -> modelMapper.map(spdt, SelectiveProcessDocumentTypeDto.class)).collect(Collectors.toList());
	}

}
