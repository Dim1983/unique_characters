package com.dloktionov.uniquecharacters.counter;

public interface UniqueCharacterProvider<T> {
    String checkOccurrenceSymbols(T text);
}
