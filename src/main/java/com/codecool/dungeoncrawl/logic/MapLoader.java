package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Door;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.*;
import com.codecool.dungeoncrawl.data.actors.enemies.Cow;
import com.codecool.dungeoncrawl.data.actors.enemies.Enemy;
import com.codecool.dungeoncrawl.data.actors.enemies.Octopus;
import com.codecool.dungeoncrawl.data.actors.enemies.Skeleton;
import com.codecool.dungeoncrawl.data.items.Key;


import java.io.InputStream;
import java.util.Collections;
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
                            map.enemyManager.addEnemy(new Skeleton(cell, "skeleton"));
                            System.out.println( map.enemyManager.getEnemy("skeleton"));
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Key(cell, "crown");
                            break;
                        case 'w':
                            Door destructibleWall = new Door(map, cell.getX(), cell.getY(), CellType.DOOR, "pickaxe", "destructible_wall");
                            map.placeCell(destructibleWall);
                            break;
                        case 'p':
                            cell.setType(CellType.FLOOR);
                            new Key(cell, "pickaxe");
                            break;
                        case 'd':
                            cell.setType(CellType.FLOOR);
                            map.setDog(new Dog(cell));
                            break;
                        case 'c':
                            cell.setType(CellType.FLOOR);
                            map.enemyManager.addEnemy(new Cow(cell, "cow"));
                            break;
                        case 'o':
                            cell.setType(CellType.FLOOR);
                            map.setOctopus(new Octopus(cell, "octopus"));
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
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
