package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;


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
        Player player = this.getCell().getGameMap().getPlayer();

        int dx = Integer.compare(player.getCurrrentCoord()[0], this.getX());
        int dy = Integer.compare(player.getCurrrentCoord()[1], this.getY());

        Cell nextCell = this.getCell().getNeighbor(dx, dy);
//        this.attack(nextCell);

        super.move(dx, dy);
    }
}

