package com.codecool.dungeoncrawl.data;

public class Door extends Cell {
    private final String key;
    private String name;


    public Door(GameMap gameMap, int x, int y, CellType type, String key, String tileName) {
        super(gameMap, x, y, type);
        this.key = key;
        this.name = tileName;
    }
    public String getKey(){ return this.key; }

    private void setName(String name) {
        this.name = name;
    }
    @Override
    public String getTileName() {
        return this.outOfRange() ? "empty" : this.name;
    }
    public void setToOpen(){
        this.setName("floor");
    }
}

