package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;

public abstract class Enemy extends Actor {
    private String name;

    public Enemy(Cell cell, String name) {
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
        return this.getCell().outOfRange() ? "empty" : name;
    }

    @Override
    public void kill() {
        super.kill();
        getCell().getGameMap().EnemyManager.removeEnemy((Enemy) this);
    }
}
