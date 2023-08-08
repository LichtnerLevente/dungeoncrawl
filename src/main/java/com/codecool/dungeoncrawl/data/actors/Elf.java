package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Elf extends Actor{
    private int health = 20;

    public Elf(Cell cell) {
        super(cell);
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String getTileName() {
        return "elf";
    }
}
