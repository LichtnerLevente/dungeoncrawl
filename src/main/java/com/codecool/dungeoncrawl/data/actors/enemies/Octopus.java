package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import java.util.Random;

public class Octopus extends Enemy {
    private int health = 20;

    private int damage = 9;

    public Octopus(Cell cell, String name) {
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

    public void moveOctopus() {
        Random random = new Random();
        int randomDx = random.nextInt(3) -1;
        int randomDy = random.nextInt(3) -1;
        super.move(randomDx, randomDy);
    }
}

