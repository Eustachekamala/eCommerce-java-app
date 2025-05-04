package com.eustachecode.eCommerce_java_app.models;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CurrencyConverter implements AttributeConverter<Currency, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Currency currency) {
        if (currency == null) {
            return null;
        }
        return currency.ordinal(); // Store as the ordinal value (0 = USD, 1 = KES, etc.)
    }

    @Override
    public Currency convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return Currency.values()[dbData]; // Retrieve the enum by its ordinal value
    }
}
