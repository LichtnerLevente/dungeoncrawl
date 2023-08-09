package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

import java.util.Random;

public class Octopus extends Actor{
    private int health = 20;

    private int damage = 9;

    public Octopus(Cell cell) {
        super(cell);
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

    @Override
    public String getTileName() {
        return "octopus";
    }
}

