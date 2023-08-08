package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Door;
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
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
            }
        }
        if (nextCell.getItem() != null) {
            //itempickup
            inventory.add((Key) nextCell.getItem());
        }
        if (checkIfValidTile(nextCell)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public String getTileName() {
        return "player";
    }
    private boolean checkIfValidTile(Cell cell) {
        if (cell.getTileName().equals("wall") || cell.getType().equals(CellType.DOOR)) return false;
        return cell.getActor() == null;
    }
}
