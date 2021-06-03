package com.dloktionov.uniquecharacters.validator;

public class UniqueValidatorImpl implements UniqueValidator<String> {

    @Override
    public void validation(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Argument is null!");
        }
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Argument is blank line!");
        }
    }
}
