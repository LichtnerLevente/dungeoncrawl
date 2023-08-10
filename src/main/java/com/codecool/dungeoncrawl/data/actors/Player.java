package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Door;
import com.codecool.dungeoncrawl.data.items.Inventory;
import com.codecool.dungeoncrawl.data.items.InventoryImpl;
import com.codecool.dungeoncrawl.data.items.Key;


import java.util.HashSet;

public class Player extends Actor {
    private int health = 10;

    private int damage = 5;

    private final Inventory inventory = new InventoryImpl(new HashSet<>());

    static int [] currrentCoord = new int[2];
    static int [] prevCoord = new int[2];

    public Player(Cell cell) {
        super(cell);
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if(nextCell.getActor() != null && nextCell.getActor().getTileName().equals("cat")) {
            ((Cat) nextCell.getActor()).setShouldMove(true);
        }
        else if (nextCell.getActor() != null) {
            attackingMonster(nextCell, nextCell.getActor());
        }
        if(nextCell.getType().equals(CellType.DOOR)){
            Door door = (Door) nextCell;
            if (inventory.contains(door.getKey())){
                door.setToOpen();
                moveToTile(nextCell);
            }
        }
        if (nextCell.getItem() != null) {
            pickUpItem(nextCell);
            if (inventory.contains("sword")) {
                setDamage(1000);
            }
        }
        if (checkIfValidTile(nextCell)) {
            prevCoord[0] = cell.getX();
            prevCoord[1] = cell.getY();
            moveToTile(nextCell);
        }
    }

    public String getTileName() {
        return this.getCell().outOfRange() ? "empty" : "player";
    }

    private void  pickUpItem(Cell cell){
        inventory.add(cell.getItem());
        if (cell.getItem().getName().equals("shield")) {
            setHealth(health = 10000);
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
            if (monster.getTileName().equals("cow")) {
                inventory.add(new Key(cell, "monster_key"));
            }
            cell.getActor().kill();

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

    public static int[] getCurrrentCoord() {
        return currrentCoord;
    }

    public static void setCurrrentCoord(int x, int y) {
        Player.currrentCoord[0] = x;
        Player.currrentCoord[1] = y;
    }

    @Override
    protected void moveToTile(Cell nextCell) {
        Player.setCurrrentCoord(nextCell.getX(), nextCell.getY());
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
