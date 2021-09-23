package com.mitocode.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDate;


@Converter(autoApply = true)
public class MyLocalDateTimeConverter implements AttributeConverter<LocalDate, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(LocalDate attribute) {
        return attribute == null ? null : java.sql.Timestamp.valueOf(String.valueOf(attribute));
    }

    @Override
    public LocalDate convertToEntityAttribute(Timestamp dbData) {
        return dbData == null ? null : LocalDate.from(dbData.toLocalDateTime());
    }
}
