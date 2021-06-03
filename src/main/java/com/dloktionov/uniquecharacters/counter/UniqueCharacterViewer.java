package com.dloktionov.uniquecharacters.counter;

public interface UniqueCharacterViewer<K, T> {
    String provideView(K k, T t);
}


