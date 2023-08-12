package com.codecool.dungeoncrawl.data;

public enum CellType {
    EMPTY("empty", false),
    FLOOR("floor", true),
    WALL("wall", false),
    DOOR("door", false),
    OPEN_DOOR("openDoor", true);
    private final String tileName;
    private final boolean movable;

    CellType(String tileName, boolean movable) {
        this.tileName = tileName;
        this.movable = movable;
    }

    public String getTileName() {
        return tileName;
    }

    public boolean isMovable() {
        return movable;
    }
}
