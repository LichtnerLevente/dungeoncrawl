package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Key;

import java.util.Random;

public class Cow extends Enemy {
    private int health = 15;

    private int damage = 5;

    public Cow(Cell cell, String name) {
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

    @Override
    public void move() {
        Random random = new Random();
        int randomDx = random.nextInt(3) -1;
        int randomDy = random.nextInt(3) -1;
        super.move(randomDx, randomDy);
    }

    @Override
    public void kill() {
        this.getCell().getGameMap().getPlayer().getInventory().add(new Key(this.getCell(), "monster_key"));
        super.kill();
    }
}
