package com.dloktionov.uniquecharacters.counter;

import java.util.Map;

public class UniqueCharacterViewerImpl implements UniqueCharacterViewer<String, Map<Character, Integer>> {
    private static final String STEP_COUNT = "\"%s\" -%d\n";
    private static final String RESULT_COUNT = "%s\n%s";

    @Override
    public String provideView(String text, Map<Character, Integer> resultCheckMaps) {
        StringBuilder result = new StringBuilder();
        resultCheckMaps.forEach((k, v)->
                result.append(String.format(STEP_COUNT, k, v)));

        return String.format(RESULT_COUNT, text, result);
    }
}
