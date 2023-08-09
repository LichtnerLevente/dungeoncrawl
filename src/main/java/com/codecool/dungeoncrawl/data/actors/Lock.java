package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Lock extends Actor{
    private String name;
    public Lock(Cell cell) {
        super(cell);
        name = "blue_lock";
    }

    @Override
    public String getTileName() {
        return name;
    }

}
