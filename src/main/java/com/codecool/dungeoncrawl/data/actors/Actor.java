package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    Cell cell;
    int health;
    int damage;
    private String name;

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

    public int getHealth() {
        return health;
    }
    public void kill(){
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
    public boolean isCat(){
        return this != null && this.getTileName().equals("cat");
    }

}
