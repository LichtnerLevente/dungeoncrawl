package com.codecool.dungeoncrawl.data.items;

import java.util.Set;

public interface Inventory {
    Set<Key> getItems();
    void add(Key item);
    boolean contains(String key);
}
