package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.logic.GameLogic;

import static java.lang.Math.sqrt;

public class Cell implements Drawable {
    private CellType type;
    private Actor actor;
    private Item item;
    private final GameMap gameMap;
    private final int x, y;

    public Cell(GameMap gameMap, int x, int y, CellType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return this.item;
    }

    public Cell getNeighbor(int dx, int dy) {
        return gameMap.getCell(x + dx, y + dy);
    }
    public Cell getCell(int x, int y) {return gameMap.getCell(x,y);}

    @Override
    public String getTileName() {
        return this.outOfRange() ? "fog" : type.getTileName();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    private double getDistanceFromPlayer(){
        double px = getGameMap().getPlayer().getCurrrentCoord()[0];
        double py = getGameMap().getPlayer().getCurrrentCoord()[1];

        return sqrt(Math.pow((this.x-px), 2) + Math.pow((this.y-py), 2));
    }
    public boolean outOfRange(){
        return this.getDistanceFromPlayer() > GameLogic.getVisionRange();
    }

    public boolean isDoor() {
        return this.getType().equals(CellType.DOOR);
    }


    public GameMap getGameMap() {
        return gameMap;
    }
}
