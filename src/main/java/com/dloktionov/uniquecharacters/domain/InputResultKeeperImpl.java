package com.dloktionov.uniquecharacters.domain;

import java.util.HashMap;
import java.util.Map;

public class InputResultKeeperImpl implements InputResultKeeper<String, Map<Character, Integer>> {

    private final Map<String, Map<Character, Integer>> resultCounts = new HashMap<>();

    @Override
    public void put(String key, Map<Character, Integer> value) {
        resultCounts.put(key, value);
    }

    @Override
    public Map<Character, Integer> get(String key) {

        return resultCounts.get(key);
    }

    @Override
    public boolean contains(String key) {
        return resultCounts.containsKey(key);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "InputResultKeeperImpl{" +
                "resultCount=" + resultCounts +
                '}';
    }
}
