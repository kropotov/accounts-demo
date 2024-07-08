package dev.kropotov.accounts.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class BranchConverter implements AttributeConverter<Branch, String> {
    @Override
    public String convertToDatabaseColumn(Branch branch) {
        return branch.getCode();
    }

    @Override
    public Branch convertToEntityAttribute(String code) {
        return Stream.of(Branch.values())
                .filter(branch -> branch.getCode().equals(code))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
