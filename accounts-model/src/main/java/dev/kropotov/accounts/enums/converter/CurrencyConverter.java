package dev.kropotov.accounts.enums.converter;

import dev.kropotov.accounts.enums.Currency;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class CurrencyConverter implements AttributeConverter<Currency, String> {
    @Override
    public String convertToDatabaseColumn(Currency currency) {
        return currency.getCode();
    }

    @Override
    public Currency convertToEntityAttribute(String code) {
        return Stream.of(Currency.values())
                .filter(currency -> currency.getCode().equals(code))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
