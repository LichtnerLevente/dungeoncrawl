package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Arrays;

public class Dog extends Actor{
    private boolean shouldMove = false;
    public Dog(Cell cell) {
        super(cell);
    }
    @Override
    public String getTileName() {
        return "dog";
    }

    public void changeShouldMove(boolean bool) {
        this.shouldMove = bool;
    }


    public void moveDog() {
        Cell nextCell = cell.getCell(prevCoord[0],prevCoord[1]);
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        System.out.println(prevCoord[0]);
        System.out.println(prevCoord[1]);
        System.out.println(Arrays.toString(prevCoord));

    }
}
