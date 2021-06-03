package com.dloktionov.uniquecharacters.counter;

import com.dloktionov.uniquecharacters.domain.InputResultKeeper;
import com.dloktionov.uniquecharacters.validator.UniqueValidator;

import java.util.Map;

public class UniqueCharacterProviderImpl implements UniqueCharacterProvider<String> {
    private final UniqueValidator<String> uniqueValidator;
    private final QuantityCharCounter<String> quantityCharCounter;
    private final UniqueCharacterViewer<String, Map<Character, Integer>> uniqueCharacterViewer;
    private final InputResultKeeper<String, Map<Character, Integer>> inputResultKeeper;

    public UniqueCharacterProviderImpl(UniqueValidator<String> uniqueValidator,
                                       InputResultKeeper<String, Map<Character, Integer>> inputResultKeeper,
                                       QuantityCharCounter<String> quantityCharCounter,
                                       UniqueCharacterViewer<String, Map<Character, Integer>> uniqueCharacterViewer) {
        this.uniqueValidator = uniqueValidator;
        this.inputResultKeeper = inputResultKeeper;
        this.quantityCharCounter = quantityCharCounter;
        this.uniqueCharacterViewer = uniqueCharacterViewer;
    }

    public String checkOccurrenceSymbols(String text) {
        uniqueValidator.validation(text);

        final Map<Character, Integer> countSymbols;
        if (inputResultKeeper.contains(text)) {
            return uniqueCharacterViewer.provideView(text, inputResultKeeper.get(text));
        } else {
            countSymbols = quantityCharCounter.countQuantityCharactersInLine(text);
            inputResultKeeper.put(text, countSymbols);
        }

        return uniqueCharacterViewer.provideView(text, countSymbols);
    }
}
