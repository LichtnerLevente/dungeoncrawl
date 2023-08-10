package com.codecool.dungeoncrawl.data;

public class Door extends Cell {
    private final String key;
    private String name;
    private String type;
    private String openVersion;


    public Door(GameMap gameMap, int x, int y, CellType type, String key, String tileName, String openVersion) {
        super(gameMap, x, y, type);
        this.key = key;
        this.name = tileName;
        this.openVersion = openVersion;
    }

    public String getKey() {
        return this.key;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getTileName() {
        return this.outOfRange() ? "fog" : this.name;
    }

    public void setToOpen() {
        this.setName(this.openVersion);
    }
}

