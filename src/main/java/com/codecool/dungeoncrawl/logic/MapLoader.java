package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Door;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.*;
import com.codecool.dungeoncrawl.data.actors.enemies.*;
import com.codecool.dungeoncrawl.data.items.Key;
import com.codecool.dungeoncrawl.data.items.Tool;


import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MapLoader {
    public static GameMap loadMap(String mapName) {
        InputStream is = MapLoader.class.getResourceAsStream("/" + mapName + ".txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        Set<Enemy> enemies = new HashSet<>();

        GameMap map = new GameMap(width, height, CellType.EMPTY, enemies);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ' -> cell.setType(CellType.EMPTY);
                        case '#' -> cell.setType(CellType.WALL);
                        case '.' -> cell.setType(CellType.FLOOR);
                        case 's' -> {
                            cell.setType(CellType.FLOOR);
                            map.EnemyManager.addEnemy(new Skeleton(cell));
                        }
                        case 'k' -> {
                            cell.setType(CellType.FLOOR);
                            new Key(cell, "crown");
                        }
                        case 'w' -> {
                            Door destructibleWall = new Door(map, cell.getX(), cell.getY(), CellType.DOOR, "pickaxe", "destructible_wall", "floor");
                            map.placeCell(destructibleWall);
                        }
                        case 'u' -> {
                            Door door = new Door(map, cell.getX(), cell.getY(), CellType.DOOR, "monster_key", "door", "open_door");
                            map.placeCell(door);
                        }
                        case 'f' -> {
                            cell.setType(CellType.FLOOR);
                            new Key(cell, "fish");
                        }
                        case '1' -> {
                            Door blue_door = new Door(map, cell.getX(), cell.getY(), CellType.DOOR, "blue_key", "blue_door", "blue_open_door");
                            map.placeCell(blue_door);
                        }
                        case '2' -> {
                            cell.setType(CellType.FLOOR);
                            new Key(cell, "blue_key");
                        }
                        case 'p' -> {
                            cell.setType(CellType.FLOOR);
                            new Key(cell, "pickaxe");
                        }
                        case 'r' -> {
                            cell.setType(CellType.FLOOR);
                            new Tool(cell, "sword", () -> map.getPlayer().setDamage(20));
                        }
                        case 'h' -> {
                            cell.setType(CellType.FLOOR);
                            new Tool(cell, "shield", () -> map.getPlayer().setHealth(map.getPlayer().getHealth() + 20));
                        }
                        case 't' -> {
                            cell.setType(CellType.FLOOR);
                            new Tool(cell, "torch", () -> GameLogic.setVisionRange(7));
                        }
                        case 'd' -> {
                            cell.setType(CellType.FLOOR);
                            map.setCat(new Cat(cell));
                        }
                        case 'c' -> {
                            cell.setType(CellType.FLOOR);
                            map.EnemyManager.addEnemy(new Cow(cell));
                        }
                        case 'o' -> {
                            cell.setType(CellType.FLOOR);
                            map.EnemyManager.addEnemy(new Octopus(cell));
                        }
                        case 'g' -> {
                            cell.setType(CellType.FLOOR);
                            map.EnemyManager.addEnemy(new Ghost(cell));
                        }
                        case '@' -> {
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            map.getPlayer().setCurrrentCoord(cell.getX(), cell.getY());
                        }
                        default -> throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }
}
