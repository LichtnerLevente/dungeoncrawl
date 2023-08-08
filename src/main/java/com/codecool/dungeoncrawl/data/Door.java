package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.items.Item;

public class Door extends Cell {
    private final String key;
    private final String name;

    public Door(GameMap gameMap, int x, int y, CellType type, String key, String tileName) {
        super(gameMap, x, y, type);
        this.key = key;
        this.name = tileName;
    }
    public String getKey(){ return this.key; }

    @Override
    public String getTileName() {
        return this.name;
    }
}
