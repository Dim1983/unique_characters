package com.dloktionov.uniquecharacters.domain;

public interface InputResultKeeper<K, V> {
    void put(K key, V value);

    V get(K key);

    boolean contains(K key);
}
