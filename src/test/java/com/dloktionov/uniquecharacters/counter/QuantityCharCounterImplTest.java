package com.dloktionov.uniquecharacters.counter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class QuantityCharCounterImplTest {
    private final QuantityCharCounter quantityCharCounter = new QuantityCharCounterImpl();

    @Test
    void countQuantityCharactersInLineShouldBeReturnMapWithOneSymbolIncludeAnyTime() {
        Map<Character, Integer> expected  = new HashMap<Character, Integer>() {{
            put('h', 5);
        }};
        Map<Character, Integer> result = quantityCharCounter.countQuantityCharactersInLine("hhhhh");

        assertThat(expected, is(result));
    }

    @Test
    void countQuantityCharactersInLineShouldBeReturnMapIncludeNumberConvertToChar() {
        Map<Character, Integer> expected  = new HashMap<Character, Integer>() {{
            put('1', 1);
            put('2', 1);
            put('3', 1);
            put('4', 1);
            put('5', 1);
        }};
        Map<Character, Integer> result = quantityCharCounter.countQuantityCharactersInLine("12345");

        assertThat(expected, is(result));
    }

    @Test
    void countQuantityCharactersInLineShouldBeReturnMapIncludeSpecialSymbol() {
        Map<Character, Integer> expected  = new HashMap<Character, Integer>() {{
            put('!', 1);
            put('@', 2);
            put('$', 1);
            put('%', 1);
            put('^', 1);
        }};
        Map<Character, Integer> result = quantityCharCounter.countQuantityCharactersInLine("!@@$%^");

        assertThat(expected, is(result));
    }
}
