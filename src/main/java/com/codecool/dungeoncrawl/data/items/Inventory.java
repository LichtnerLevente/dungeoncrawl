package com.codecool.dungeoncrawl.data.items;

import java.util.Set;

public interface Inventory {
    Set<Item> getItems();
    void addItem(Item item);
    boolean containsItem(Item item);
}
