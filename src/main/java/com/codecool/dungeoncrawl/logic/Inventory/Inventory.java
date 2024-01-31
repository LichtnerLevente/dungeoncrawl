package com.codecool.dungeoncrawl.logic.Inventory;

import com.codecool.dungeoncrawl.data.items.Item;

import java.util.Set;

public interface Inventory {
    Set<Item> getItems();
    void add(Item item);
    boolean contains(String name);
}
