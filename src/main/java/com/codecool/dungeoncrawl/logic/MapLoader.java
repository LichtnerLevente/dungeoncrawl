package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Door;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.*;
import com.codecool.dungeoncrawl.data.actors.enemies.*;
import com.codecool.dungeoncrawl.data.items.Key;


import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
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
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            map.EnemyManager.addEnemy(new Skeleton(cell, "skeleton"));
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Key(cell, "crown");
                            break;
                        case 'w':
                            Door destructibleWall = new Door(map, cell.getX(), cell.getY(), CellType.DOOR, "pickaxe", "destructible_wall", "floor");
                            map.placeCell(destructibleWall);
                            break;
                        case 'u':
                            Door door = new Door(map, cell.getX(), cell.getY(), CellType.DOOR, "monster_key", "door", "open_door");
                            map.placeCell(door);
                            break;
                        case 'f':
                            cell.setType(CellType.FLOOR);
                            new Key(cell, "fish");
                            break;
                        case '1':
                            Door blue_door = new Door(map, cell.getX(), cell.getY(), CellType.DOOR, "blue_key", "blue_door", "blue_open_door");
                            map.placeCell(blue_door);
                            break;
                        case '2':
                            cell.setType(CellType.FLOOR);
                            new Key(cell, "blue_key");
                            break;
                        case 'p':
                            cell.setType(CellType.FLOOR);
                            new Key(cell, "pickaxe");
                            break;
                        case 'r':
                            cell.setType(CellType.FLOOR);
                            new Key(cell, "sword");
                            break;
                        case 'h':
                            cell.setType(CellType.FLOOR);
                            new Key(cell, "shield");
                            break;
                        case 't':
                            cell.setType(CellType.FLOOR);
                            new Key(cell, "torch");
                            break;
                        case 'd':
                            cell.setType(CellType.FLOOR);
                            map.setDog(new Cat(cell));
                            break;
                        case 'c':
                            cell.setType(CellType.FLOOR);
                            map.EnemyManager.addEnemy(new Cow(cell, "cow"));
                            break;
                        case 'o':
                            cell.setType(CellType.FLOOR);
                            map.EnemyManager.addEnemy(new Octopus(cell, "octopus"));
                            break;
                        case 'g':
                            cell.setType(CellType.FLOOR);
                            map.EnemyManager.addEnemy(new Ghost(cell, "ghost"));
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            Player.setCurrrentCoord(cell.getX(), cell.getY());
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }
}
