package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Door;
import com.codecool.dungeoncrawl.data.items.*;


import java.util.HashSet;

public class Player extends Actor {
    private int health = 10;

    private int damage = 5;

    private final Inventory inventory = new InventoryImpl(new HashSet<>());

    private int[] currrentCoord = new int[2];
    private int[] prevCoord = new int[2];

    public Player(Cell cell) {
        super(cell);
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
            prevCoord[0] = cell.getX();
            prevCoord[1] = cell.getY();
            moveToTile(nextCell);
        }
    }

    public String getTileName() {
        return this.getCell().outOfRange() ? "fog" : "player";
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

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
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
        this.setCurrrentCoord(nextCell.getX(), nextCell.getY());
        super.moveToTile(nextCell);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
