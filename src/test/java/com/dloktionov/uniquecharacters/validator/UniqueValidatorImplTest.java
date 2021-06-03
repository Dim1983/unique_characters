package com.dloktionov.uniquecharacters.validator;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UniqueValidatorImplTest {

    private final UniqueValidator uniqueValidator = new UniqueValidatorImpl();

    @Test
    void validationShouldBeThrownIllegalArgumentExceptionIfTextEmpty() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> uniqueValidator.validation(""));

        assertThat("Argument is blank line!", is(thrown.getMessage()));
    }

    @Test
    void validationShouldBeThrownIllegalArgumentExceptionIfTextNull() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> uniqueValidator.validation(null));

        assertThat("Argument is null!", is(thrown.getMessage()));
    }

    @Test
    void validationShouldBeReturnTrueIfString() {
        String text = "Hello world!";
        assertDoesNotThrow(() -> uniqueValidator.validation(text));
    }
}
