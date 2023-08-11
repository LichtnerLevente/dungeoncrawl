package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import java.util.Random;
public class Ghost extends Enemy{
    private static final int BASE_HEALTH = 6;
    private static final int BASE_DAMAGE = 25;

    public Ghost(Cell cell, String name) {
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

//    @Override
//    public void move(int dx, int dy) {
//
//        Cell nextCell = cell.getCell()
//    }

    @Override
    public void move() {
        Random random = new Random();

        int randomDx = random.nextInt(25);
        int randomDy = random.nextInt(20);

        Cell nextCell = getCell().getCell(randomDx, randomDy);
        if (checkIfValidTile(nextCell)) {
                moveToTile(nextCell);

        }



    }
}
