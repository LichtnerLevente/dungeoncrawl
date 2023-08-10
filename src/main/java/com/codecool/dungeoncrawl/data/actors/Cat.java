package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Cat extends Actor {
    boolean shouldMove = false;

    public Cat(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return this.getCell().outOfRange() ? "empty" : "cat";
    }

    void setShouldMove(boolean bool) {
        this.shouldMove = bool;
    }


    public void moveCat() {
        Cell nextCell = getCell().getCell(Player.getPrevCoord()[0], Player.getPrevCoord()[1]);
        if (checkIfValidTile(nextCell)) {
            if (shouldMove) {
                moveToTile(nextCell);
            }
        }
    }
}
