package ingresso.converter;

import java.util.Objects;
import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import ingresso.model.SelectiveProcessType;

@Converter(autoApply = true)
public class SelectiveProcessTypeConverter implements AttributeConverter<SelectiveProcessType, String> {

	@Override
	public String convertToDatabaseColumn(SelectiveProcessType type) {
		if (Objects.isNull(type)) {
			return null;
		}
		return type.getDescription();
	}

	@Override
	public SelectiveProcessType convertToEntityAttribute(String description) {
		if (Objects.isNull(description)) {
			return null;
		}
		return Stream.of(SelectiveProcessType.values())
				.filter(t -> t.getDescription().equals(description))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
