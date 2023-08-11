package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;

public class Skeleton extends Enemy {
    private static final int BASE_HEALTH = 5;
    private static final int BASE_DAMAGE = 2;

    public Skeleton(Cell cell, String name) {
        super(cell, name);
        health = BASE_HEALTH;
        damage = BASE_DAMAGE;
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
