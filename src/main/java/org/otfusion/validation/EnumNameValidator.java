package org.otfusion.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Validator to assert the Enum name to a String value.
 */
public class EnumNameValidator implements ConstraintValidator<EnumName, String> {

    private Set<String> validValues;

    @Override
    public void initialize(EnumName annotation) {
        Class<? extends Enum> enumSelectedArray[] = annotation.enumsToValidate();

        validValues = new LinkedHashSet<>();

        for (Class<? extends Enum> enumSelected : enumSelectedArray) {
            Enum[] enumConstants = enumSelected.getEnumConstants();
            for (Enum enumConstant : enumConstants) {
                validValues.add(enumConstant.name());
            }
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = validValues.contains(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    String.format("The value %s is not one of: %s", value, validValues)
            ).addConstraintViolation();
        }

        return isValid;
    }

}
