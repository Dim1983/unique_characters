package com.dloktionov.uniquecharacters.counter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class UniqueCharacterViewerImplTest {
    private final UniqueCharacterViewer uniqueCharacterViewer = new UniqueCharacterViewerImpl();

    @Test
    void resultCountShouldBeReturnString() {
        Map<Character, Integer> resultMaps  = new HashMap<Character, Integer>() {{
            put('h', 5);
        }};

        String expected = "h\n\"h\" -5\n";
        String result = uniqueCharacterViewer.provideView("h",resultMaps);

        assertThat(expected, is(result));
    }

    @Test
    void resultCountShouldBeReturnStringIncludeOnlyNumber() {
        Map<Character, Integer> resultMaps  = new HashMap<Character, Integer>() {{
            put('1', 1);
            put('2', 1);
            put('3', 1);
            put('4', 1);
            put('5', 1);
        }};

        String expected = "12345\n\"1\" -1\n\"2\" -1\n\"3\" -1\n\"4\" -1\n\"5\" -1\n";
        String result = uniqueCharacterViewer.provideView("12345",resultMaps);

        assertThat(expected, is(result));
    }

    @Test
    void resultCountShouldBeReturnStringIncludeOnlySpecialSymbols() {
        Map<Character, Integer> resultMaps  = new HashMap<Character, Integer>() {{
            put('!', 1);
            put('@', 2);
            put('#', 1);
            put('$', 1);
            put('%', 1);
        }};

        String expected = "!@#$%\n\"@\" -2\n\"!\" -1\n\"#\" -1\n\"$\" -1\n\"%\" -1\n";
        String result = uniqueCharacterViewer.provideView("!@#$%", resultMaps);

        assertThat(expected, is(result));
    }
}
