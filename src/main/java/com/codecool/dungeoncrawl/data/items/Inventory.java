package com.codecool.dungeoncrawl.data.items;

import java.util.Set;

public interface Inventory {
    Set<Item> getItems();
    void add(Item item);
    boolean contains(String name);
}
