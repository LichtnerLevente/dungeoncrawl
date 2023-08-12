package com.codecool.dungeoncrawl.data;

public class Door extends Cell {
    private final String key;
    private final String tileName;
    private boolean isOpen;
    private final String openVersion;


    public Door(GameMap gameMap, int x, int y, CellType type, String key, String tileName, String openVersion) {
        super(gameMap, x, y, type);
        this.key = key;
        this.tileName = tileName;
        this.openVersion = openVersion;
        this.isOpen = false;
    }

    public String getKey() {
        return this.key;
    }
    @Override
    public String getTileName() {
        return this.outOfRange() ? "fog" : (isOpen ? openVersion : tileName);
    }

    public void setToOpen() {
        this.isOpen = true;
    }
}

