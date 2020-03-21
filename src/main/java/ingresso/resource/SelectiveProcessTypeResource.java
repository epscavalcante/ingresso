package ingresso.resource;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.dto.SelectOptionDto;
import ingresso.model.SelectiveProcessType;

@RestController
public class SelectiveProcessTypeResource {

	@GetMapping("/selective-process-types")
	public Collection<SelectOptionDto> findAll() {
		return Arrays.stream(SelectiveProcessType.values())
				.map(type -> new SelectOptionDto(type.name(), type.getDescription()))
				.collect(Collectors.toList());
	}

}
