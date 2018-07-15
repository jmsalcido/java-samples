package org.otfusion.validation;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EnumNameValidatorTest {

    @EnumName(enumsToValidate = {TestEnum.class, TestEnum2.class})
    private String property;

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testPropertyIsCorrect() {
        property = TestEnum.Uno.name();
        Set<ConstraintViolation<EnumNameValidatorTest>> validate = validator.validate(this);
        assertThat(validate, Matchers.emptyIterable());
    }

    @Test
    public void testPropertyIsIncorrect() {
        property = "NotPossibleBro";
        Set<ConstraintViolation<EnumNameValidatorTest>> validate = validator.validate(this);
        assertThat(validate, Matchers.hasSize(1));
        assertThat(validate.iterator().next().getMessage(),
                is("The value NotPossibleBro is not one of: " +
                        "[Uno, Dos, Tres, Cuatro, Cinco, Seis]"));
    }

    private enum TestEnum {
        Uno,
        Dos,
        Tres
        ;
    }

    private enum TestEnum2 {
        Cuatro,
        Cinco,
        Seis
        ;
    }

}