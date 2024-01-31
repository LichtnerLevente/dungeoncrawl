package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.Inventory.Modify;

public class Tool extends  Item{
    private static final ItemType type = ItemType.TOOL;
    private final Modify modify;

    public Tool(Cell cell, String name, Modify modify) {
        super(cell, name, type);
        this.modify = modify;
    }

    public void modifyStat(){
        modify.perform();
    }
}
