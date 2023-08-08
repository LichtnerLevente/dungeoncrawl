package com.codecool.dungeoncrawl.data.item;

import java.util.List;

public interface Inventory {
    List<Item> getItems();
    void addItem(Item item);
    boolean containsItem(String name);
}
