package com.codecool.dungeoncrawl.data.actors.npcs;

import com.codecool.dungeoncrawl.data.Cell;

public class Skeleton extends NPC {
    private int health = 5;

    private int damage = 2;

    public Skeleton(Cell cell, String name) {
        super(cell, name);
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }
}
