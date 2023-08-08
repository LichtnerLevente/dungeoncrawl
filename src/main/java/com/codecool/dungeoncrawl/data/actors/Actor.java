package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getActor() != null) {
            attackingMonster(nextCell, nextCell.getActor());
        }
        if (checkIfValidTile(nextCell)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public void attackingMonster(Cell cell, Actor monster) {
        int monsterNewHealth = monster.getHealth() - 5;

        System.out.println("Monster's starting health: " + monster.getHealth());
        System.out.println("Monster's new health: " + monsterNewHealth);
        System.out.println("Monster's type: " + monster.getTileName());

        if (monsterNewHealth > 0) {
            monster.setHealth(monsterNewHealth);
            health = health - 2;
            System.out.println(monster.getHealth());
        } else {
            cell.setActor(null);
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    private boolean checkIfValidTile(Cell cell) {
        if (cell.getTileName().equals("wall")) return false;
        if (cell.getActor() != null) return false;

        return true;
    }
}
