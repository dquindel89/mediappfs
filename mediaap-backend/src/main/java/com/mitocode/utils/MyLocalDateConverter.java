package com.mitocode.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDateTime;

@Converter(autoApply = true)
public class MyLocalDateConverter implements AttributeConverter<java.time.LocalDateTime, java.sql.Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime attribute) {
        return attribute == null ? null : java.sql.Date.valueOf(String.valueOf(attribute));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date dbData) {
        return dbData == null ? null : LocalDateTime.from(dbData.toLocalDate());
    }
}
