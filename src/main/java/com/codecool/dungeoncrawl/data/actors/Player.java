package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Door;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.items.Inventory;
import com.codecool.dungeoncrawl.data.items.InventoryImpl;
import com.codecool.dungeoncrawl.data.items.Key;

import java.util.HashSet;

public class Player extends Actor {

    private final Inventory inventory = new InventoryImpl(new HashSet<>());

    public Player(Cell cell) {
        super(cell);
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if(nextCell.getType().equals(CellType.DOOR)){
            Door door = (Door) nextCell;
            if (inventory.contains(door.getKey())){
                openDoor(door);
                moveToNextTile(nextCell);
            }
        }
        if (nextCell.getItem() != null) {
            pickUpItem(nextCell);
        }
        if (checkIfValidTile(nextCell)) {
            moveToNextTile(nextCell);
        }
    }

    public String getTileName() {
        return "player";
    }
    private void moveToNextTile(Cell nextCell) {
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
    }
    private void  pickUpItem(Cell cell){
        inventory.add((Key) cell.getItem());
        cell.setItem(null);

    }
    private void openDoor(Door door){
        door.setName("floor");
    }
    private boolean checkIfValidTile(Cell cell) {
        if (cell.getTileName().equals("wall") || cell.getType().equals(CellType.DOOR)) return false;
        return cell.getActor() == null;
    }
}
