package com.dloktionov.uniquecharacters.counter;

import com.dloktionov.uniquecharacters.domain.InputResultKeeper;
import com.dloktionov.uniquecharacters.validator.UniqueValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UniqueCharacterProviderImplTest {

    @Mock
    private UniqueValidator<String> uniqueValidatorMock;

    @Mock
    private InputResultKeeper<String, Map<Character, Integer>> inputResultKeeperMock;

    @Mock
    private QuantityCharCounter<String> quantityCharCounterMock;

    @Mock
    private UniqueCharacterViewer<String, Map<Character, Integer>> uniqueCharacterViewerMock;

    @InjectMocks
    private UniqueCharacterProviderImpl uniqueCharacterProvider;

    @Test
    void calculateTestShouldBeThrowExceptionWhenArgumentIsNull() {
        doThrow(IllegalArgumentException.class).when(uniqueValidatorMock).validation("");

        assertThrows(IllegalArgumentException.class, () -> uniqueCharacterProvider.checkOccurrenceSymbols(""));

        verifyNoMoreInteractions(inputResultKeeperMock,uniqueCharacterViewerMock,quantityCharCounterMock);
    }

    @Test
    void calculateTestShouldBeReturnStringIncludeNumberConvertToStringIfCheckTrue() {
        String text = "12345";
        Map<Character, Integer> expected = new HashMap<Character, Integer>() {{
            put('1', 1);
            put('2', 1);
            put('3', 1);
            put('4', 1);
            put('5', 1);
        }};
        String resultString = "12345\n" + "\"1\" -1\n" + "\"2\" -1\n" + "\"3\" -1\n" + "\"4\" -1\n" + "\"5\" -3";

        when(inputResultKeeperMock.contains(text)).thenReturn(true);
        when(inputResultKeeperMock.get(text)).thenReturn(expected);
        when(uniqueCharacterViewerMock.provideView(text, expected)).thenReturn(resultString);

        assertThat(uniqueCharacterProvider.checkOccurrenceSymbols(text), is(resultString));

        verify(uniqueValidatorMock).validation(text);
        verify(inputResultKeeperMock).contains(text);
        verify(inputResultKeeperMock).get(text);
        verify(uniqueCharacterViewerMock).provideView(text, expected);
    }

    @Test
    void calculateTestShouldBeReturnStringIncludeNumberConvertToStringIfCheckFalse() {
        String text = "Hello World";
        Map<Character, Integer> expected = new HashMap<Character, Integer>() {{
            put(' ', 1);
            put('r', 1);
            put('d', 1);
            put('e', 1);
            put('w', 1);
            put('h', 1);
            put('l', 3);
            put('o', 2);
        }};
        String resultString = "Hello world\n" + "\" \" -1\n" + "\"r\" -1\n" + "\"d\" -1\n" + "\"e\" -1\n" + "\"w\" -1\n" +
                "\"h\" -1\n" + "\"l\" -3\n" + "\"o\" -2";

        when(quantityCharCounterMock.countQuantityCharactersInLine(text)).thenReturn(expected);
        when(uniqueCharacterViewerMock.provideView(text, expected)).thenReturn(resultString);

        assertThat(uniqueCharacterProvider.checkOccurrenceSymbols(text), is(resultString));

        verify(uniqueValidatorMock).validation(text);
        verify(quantityCharCounterMock).countQuantityCharactersInLine(text);
        verify(uniqueCharacterViewerMock).provideView(text, expected);
    }
}
