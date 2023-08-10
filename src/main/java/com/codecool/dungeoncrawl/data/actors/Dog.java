package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

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
        Cell nextCell = getCell().getCell(Player.getPrevCoord()[0], Player.getPrevCoord()[1]);
        if (checkIfValidTile(nextCell)) {
            if (shouldMove) {
                moveToTile(nextCell);
            }
        }
    }
}
