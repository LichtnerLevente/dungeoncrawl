package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Door;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.*;
import com.codecool.dungeoncrawl.data.items.Key;


import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line


        GameMap map = new GameMap(width, height, CellType.EMPTY);
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
                            new Skeleton(cell);
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
                        case 'h':
                            cell.setType(CellType.FLOOR);
                            new Key(cell, "shield");
                            break;
                        case 'd':
                            cell.setType(CellType.FLOOR);
                            map.setDog(new Dog(cell));
                            break;
                        case 'c':
                            cell.setType(CellType.FLOOR);
                            map.setCow(new Cow(cell));
                            break;
                        case 'o':
                            cell.setType(CellType.FLOOR);
                            map.setOctopus(new Octopus(cell));
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
