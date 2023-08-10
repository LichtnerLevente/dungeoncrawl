package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.npcs.*;
import com.codecool.dungeoncrawl.data.actors.Dog;
import com.codecool.dungeoncrawl.data.actors.Player;

import java.util.Set;

public class GameMap {
    private final int width;
    private final int height;
    private final Cell[][] cells;

    private Player player;

    private Dog dog;

    public NPCManager NPCManager;

    public GameMap(int width, int height, CellType defaultCellType, Set<NPC> enemies) {
        NPCManager = new NPCManagerImpl(enemies);
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void placeCell(Cell cell){
        this.cells[cell.getX()][cell.getY()] = cell;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
