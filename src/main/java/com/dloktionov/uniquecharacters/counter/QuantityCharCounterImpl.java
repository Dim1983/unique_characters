package com.dloktionov.uniquecharacters.counter;

import java.util.Map;
import java.util.stream.Collectors;

public class QuantityCharCounterImpl implements QuantityCharCounter<String> {

    @Override
    public Map<Character, Integer> countQuantityCharactersInLine(String text) {
        return text.chars()
                .mapToObj(item -> (char) item)
                .collect(Collectors.toMap(i -> i, i -> 1, (oldValue, newValue) -> oldValue + 1));
    }
}
