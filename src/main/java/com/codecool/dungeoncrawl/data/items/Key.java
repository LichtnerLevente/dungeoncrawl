package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Key extends Item {

    private static final ItemType type = ItemType.KEY;

    public Key(Cell cell, String name) {
        super(cell, name, type);
    }
}
