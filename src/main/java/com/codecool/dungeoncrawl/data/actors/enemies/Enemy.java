package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;

public abstract class Enemy extends Actor {

    public Enemy(Cell cell) {
        super(cell);
    }


    public void move(){}

    @Override
    public String getTileName() {
        return this.getCell().outOfRange() ? "fog" : name;
    }

    @Override
    public void kill() {
        super.kill();
        getCell().getGameMap().EnemyManager.removeEnemy((Enemy) this);
    }
    public void attack(Cell cell){
        Actor target = cell.getActor();
        if(target != null && !target.isCat()){
            target.setHealth(target.getHealth() - 5);
        }
    }
}
