package com.dloktionov.uniquecharacters;

import com.dloktionov.uniquecharacters.counter.QuantityCharCounter;
import com.dloktionov.uniquecharacters.counter.QuantityCharCounterImpl;
import com.dloktionov.uniquecharacters.counter.UniqueCharacterProvider;
import com.dloktionov.uniquecharacters.counter.UniqueCharacterProviderImpl;
import com.dloktionov.uniquecharacters.counter.UniqueCharacterViewer;
import com.dloktionov.uniquecharacters.counter.UniqueCharacterViewerImpl;
import com.dloktionov.uniquecharacters.domain.InputResultKeeper;
import com.dloktionov.uniquecharacters.domain.InputResultKeeperImpl;
import com.dloktionov.uniquecharacters.validator.UniqueValidator;
import com.dloktionov.uniquecharacters.validator.UniqueValidatorImpl;

import java.util.Map;

public class UniqueCharactersApp {

    public static void main(String[] args) {
        UniqueValidator<String> uniqueValidator = new UniqueValidatorImpl();

        QuantityCharCounter<String> quantityCharCounter = new QuantityCharCounterImpl();

        UniqueCharacterViewer<String, Map<Character, Integer>> uniqueCharacterViewer = new UniqueCharacterViewerImpl();

        InputResultKeeper<String, Map<Character, Integer>> inputResultKeeper = new InputResultKeeperImpl();

        UniqueCharacterProvider<String> uniqueCharacterProvider = new UniqueCharacterProviderImpl(uniqueValidator,
                inputResultKeeper, quantityCharCounter, uniqueCharacterViewer);

        System.out.println(uniqueCharacterProvider.checkOccurrenceSymbols("1234555"));
        System.out.println(uniqueCharacterProvider.checkOccurrenceSymbols("Hello worldh"));
        System.out.println(uniqueCharacterProvider.checkOccurrenceSymbols("Hello world"));
        System.out.println(uniqueCharacterProvider.checkOccurrenceSymbols("1234555"));
        System.out.println(uniqueCharacterProvider.checkOccurrenceSymbols("hhhhh"));
    }
}
