package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    protected Cell cell;
    protected int health;
    protected int damage;
    protected String name;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (checkIfValidTile(nextCell)) {
            moveToTile(nextCell);
        }
    }
    @Override
    public String getTileName() {
        return this.getCell().outOfRange() ? "fog" : name;
    }
    public int getHealth() {
        return health;
    }

    public void kill() {
        cell.setActor(null);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    protected void moveToTile(Cell nextCell) {
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
    }

    protected boolean checkIfValidTile(Cell cell) {
        return cell.getTileName().equals("floor") && !cell.getType().equals(CellType.DOOR) && cell.getActor() == null;
    }

    public boolean isCat() {
        return false;
    }

}
