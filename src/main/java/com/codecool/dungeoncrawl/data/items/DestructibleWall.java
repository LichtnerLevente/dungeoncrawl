package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class DestructibleWall extends Item {
    public DestructibleWall(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "destructible_wall";
    }
}
