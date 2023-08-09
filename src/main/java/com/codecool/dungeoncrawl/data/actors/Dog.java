package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Arrays;

public class Dog extends Actor {
    boolean shouldMove = false;

    public Dog(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "dog";
    }

    void setShouldMove(boolean bool) {
        this.shouldMove = bool;
    }


    public void moveDog() {
        Cell nextCell = cell.getCell(Player.getPrevCoord()[0], Player.getPrevCoord()[1]);
        if (checkIfValidTile(nextCell)) {
            if (shouldMove) {
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
            }
        }
    }
}
