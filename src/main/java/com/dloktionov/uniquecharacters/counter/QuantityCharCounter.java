package com.dloktionov.uniquecharacters.counter;

import java.util.Map;

public interface QuantityCharCounter<T> {
    Map<Character, Integer> countQuantityCharactersInLine(T text);
}
