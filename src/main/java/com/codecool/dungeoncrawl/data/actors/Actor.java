package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    Cell cell;
    static int [] prevCoord = new int[2];
    private int health = 10;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getItem() != null) {
            //itempickup
        }
        if (checkIfValidTile(nextCell)) {
            cell.setActor(null);
            prevCoord[0] = cell.getX();
            prevCoord[1] = cell.getY();
//            System.out.println("ACTOR" + prevCoord[0]);
//            System.out.println("ACTOR" + prevCoord[1]);
            nextCell.setActor(this);
            cell = nextCell;
        }

//        System.out.println(getX());
//        System.out.println(getY());
    }

    public int getHealth() {
        return health;
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
        if (cell.getTileName().equals("wall") || cell.getTileName().equals("door")) return false;
        return cell.getActor() == null;
    }
}
