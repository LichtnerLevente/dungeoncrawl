package com.codecool.dungeoncrawl.data.actors.npcs;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;

public abstract class NPC extends Actor {
    private String name;

    public NPC(Cell cell, String name) {
        super(cell);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void move(){}

    @Override
    public String getTileName() {
        return name;
    }
}
