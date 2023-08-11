package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;

public class Skeleton extends Enemy {
    private static final int BASE_HEALTH = 5;
    private static final int BASE_DAMAGE = 2;

    public Skeleton(Cell cell) {
        super(cell);
        name = "skeleton";
        health = BASE_HEALTH;
        damage = BASE_DAMAGE;
    }

}
