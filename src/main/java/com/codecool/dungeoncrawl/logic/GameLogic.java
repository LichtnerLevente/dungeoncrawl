package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;

public class GameLogic {
    private final GameMap map;

    private static int visionRange = 8;
    public GameLogic() {
        this.map = MapLoader.loadMap();
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }
    public String getPlayerDamage() {
        return Integer.toString(map.getPlayer().getDamage());
    }

    public String getInventoryItems() {
        return map.getPlayer().getInventory().getItems().toString();
    }


    public GameMap getMap() {
        return map;
    }

    public static int getVisionRange() {
        return visionRange;
    }
}
