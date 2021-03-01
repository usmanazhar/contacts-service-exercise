package com.silverstone.sample.contactsservice.model;

import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;
@Converter(autoApply = true)
public class PhoneTypeConverter  implements AttributeConverter<PhoneType,String> {
    @Override
    public String convertToDatabaseColumn(PhoneType phoneType) {
        if (phoneType == null) {
            return null;
        }
        return phoneType.getType();
    }

    @SneakyThrows
    @Override
    public PhoneType convertToEntityAttribute(String type) {
        if (type == null) {
            return null;
        }
        return Stream.of(PhoneType.values()).filter(t -> t.getType().equals(type))
                .findFirst()
                .orElseThrow(IllegalAccessException::new);

    }
}
