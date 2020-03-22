package ingresso.converter;

import java.util.Objects;
import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import ingresso.model.CandidateStatus;

@Converter(autoApply = true)
public class CandidateStatusConverter implements AttributeConverter<CandidateStatus, String> {

	@Override
	public String convertToDatabaseColumn(CandidateStatus status) {
		if (Objects.isNull(status)) {
			return null;
		}
		return status.getDescription();
	}

	@Override
	public CandidateStatus convertToEntityAttribute(String description) {
		if (Objects.isNull(description)) {
			return null;
		}
		return Stream.of(CandidateStatus.values())
				.filter(s -> s.getDescription().equals(description))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
