package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Cat extends Actor {
    boolean shouldMove = false;

    public Cat(Cell cell) {
        super(cell);
        name = "cat";
    }

    @Override
    public String getTileName() {
        return this.getCell().outOfRange() ? "fog" : "cat";
    }

    void setShouldMove(boolean bool) {
        this.shouldMove = bool;
    }


    public void moveCat() {
        Player player = cell.getGameMap().getPlayer();
        Cell nextCell = cell.getCell(player.getPrevCoord()[0], player.getPrevCoord()[1]);

        if (checkIfValidTile(nextCell)) {
            if (shouldMove) {
                moveToTile(nextCell);
            }
        }
    }

    @Override
    public boolean isCat() {
        return true;
    }
}
