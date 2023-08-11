package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;


public class Octopus extends Enemy {
    private static final int BASE_HEALTH = 20;
    private static final int BASE_DAMAGE = 9;

    public Octopus(Cell cell, String name) {
        super(cell, name);
        health = BASE_HEALTH;
        damage = BASE_DAMAGE;
    }

    @Override
    public void move() {
        Player player = this.getCell().getGameMap().getPlayer();

        int dx = Integer.compare(player.getCurrrentCoord()[0], this.getX());
        int dy = Integer.compare(player.getCurrrentCoord()[1], this.getY());

//        Cell nextCell = this.getCell().getNeighbor(dx, dy);
//        this.attack(nextCell);

        super.move(dx, dy);
    }
}

