package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

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

    @Override
    public void move() {

        int dx = Integer.compare(Player.getCurrrentCoord()[0], this.getX());
        int dy = Integer.compare(Player.getCurrrentCoord()[1], this.getY());

        super.move(dx, dy);
    }
}

