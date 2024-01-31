package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Door;
import com.codecool.dungeoncrawl.data.items.*;
import com.codecool.dungeoncrawl.logic.Inventory.Inventory;
import com.codecool.dungeoncrawl.logic.Inventory.InventoryImpl;


import java.util.HashSet;

public class Player extends Actor {
    private static final int BASE_HEALTH = 10;
    private static final int BASE_DAMAGE = 5;

    private final Inventory inventory = new InventoryImpl(new HashSet<>());

    private int[] currrentCoord = new int[2];
    private int[] prevCoord = new int[2];

    public Player(Cell cell) {
        super(cell);
        name = "player";
        health = BASE_HEALTH;
        damage = BASE_DAMAGE;
    }


    @Override
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);

        checkForActor(nextCell);

        if (nextCell.isDoor()) {
            Door door = (Door) nextCell;
            if (inventory.contains(door.getKey())) {
                door.setToOpen();
                moveToTile(nextCell);
            }
        }
        if (nextCell.getItem() != null) {
            pickUpItem(nextCell);
        }
        if (checkIfValidTile(nextCell)) {
            setPrevCoord(currrentCoord[0], currrentCoord[1]);
            setCurrrentCoord(nextCell.getX(), nextCell.getY());
            moveToTile(nextCell);
        }
    }

    private void pickUpItem(Cell cell) {
        Item item = cell.getItem();
        inventory.add(item);
        if (item.getType() == ItemType.TOOL) {
            Tool tool = (Tool) item;
            tool.modifyStat();
        }
        cell.setItem(null);
    }

    private void checkForActor(Cell cell) {
        Actor actor = cell.getActor();
        if (actor == null) return;
        if (actor.isCat()) {
            Cat cat = (Cat) actor;
            if (inventory.contains("fish")) {
                cat.setShouldMove(true);
            }
        } else {
            attackingMonster(cell, actor);
        }
    }

    public void attackingMonster(Cell cell, Actor monster) {
        int monsterNewHealth = monster.getHealth() - damage;

        System.out.println("Monster's starting health: " + monster.getHealth());
        System.out.println("Monster's new health: " + monsterNewHealth);
        System.out.println("Monster's type: " + monster.getTileName());

        if (monsterNewHealth > 0) {
            monster.setHealth(monsterNewHealth);
            health = getHealth() - monster.getDamage();
            System.out.println(monster.getHealth());
        } else {
            cell.getActor().kill();
        }
    }

    public int[] getPrevCoord() {
        return prevCoord;
    }

    public void setPrevCoord(int x, int y) {
        this.prevCoord[0] = x;
        this.prevCoord[1] = y;
    }
    public int[] getCurrrentCoord() {
        return currrentCoord;
    }

    public void setCurrrentCoord(int x, int y) {
        this.currrentCoord[0] = x;
        this.currrentCoord[1] = y;
    }

    @Override
    protected void moveToTile(Cell nextCell) {
        super.moveToTile(nextCell);
    }
    public Inventory getInventory() {
        return inventory;
    }
}
