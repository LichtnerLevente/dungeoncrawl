package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Random;

public class Cow extends Actor{
    private int health = 15;

    private int damage = 5;

    public Cow(Cell cell) {
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

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void moveCow() {
        Random random = new Random();
        int randomDx = random.nextInt(3) -1;
        int randomDy = random.nextInt(3) -1;
        super.move(randomDx, randomDy);
    }

    @Override
    public String getTileName() {
        return "cow";
    }
}
