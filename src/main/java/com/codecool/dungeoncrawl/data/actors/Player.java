package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Door;
import com.codecool.dungeoncrawl.data.items.Inventory;
import com.codecool.dungeoncrawl.data.items.InventoryImpl;


import java.util.HashSet;

public class Player extends Actor {
    private int health = 10;

    private int damage = 5;

    private final Inventory inventory = new InventoryImpl(new HashSet<>());

    static int [] prevCoord = new int[2];

    public Player(Cell cell) {
        super(cell);
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if(nextCell.getActor() != null && nextCell.getActor().getTileName().equals("dog")) {
            ((Dog) nextCell.getActor()).setShouldMove(true);
        }
        else if (nextCell.getActor() != null) {
            attackingMonster(nextCell, nextCell.getActor());
        }
        if(nextCell.getType().equals(CellType.DOOR)){
            Door door = (Door) nextCell;
            if (inventory.contains(door.getKey())){
                door.setToOpen();
                moveToNextTile(nextCell);
            }
        }
        if (nextCell.getItem() != null) {
            pickUpItem(nextCell);
        }
        if (checkIfValidTile(nextCell)) {
            prevCoord[0] = cell.getX();
            prevCoord[1] = cell.getY();
            moveToNextTile(nextCell);
        }
    }

    public String getTileName() {
        return "player";
    }

    private void  pickUpItem(Cell cell){
        inventory.add(cell.getItem());
        if (cell.getItem().getName().equals("shield")) {
            setHealth(health *= 2);
        }
        cell.setItem(null);
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
            cell.setActor(null);
        }
    }

    public static int[] getPrevCoord() {
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
