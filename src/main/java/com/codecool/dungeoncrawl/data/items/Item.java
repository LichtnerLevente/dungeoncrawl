package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Item implements Drawable {
    private Cell cell;
    private final ItemType  type;


    private final String name;

    public Item(Cell cell, String name, ItemType type) {
        this.cell = cell;
        this.type = type;
        this.name = name;
        this.cell.setItem(this);
    }

    public Cell getCell() {
        return cell;
    }


    public ItemType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getTileName() {
        return this.getCell().outOfRange() ? "fog" : name;
    }

    @Override
    public String toString() {
        return name;
    }
}
