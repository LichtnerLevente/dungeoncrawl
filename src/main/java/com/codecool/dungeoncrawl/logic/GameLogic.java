package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;

public class GameLogic {
    private GameMap map;
    private static int visionRange = 10;
    private boolean win = false;
    private boolean defeat = false;

    public GameLogic() {
        this.map = MapLoader.loadMap("map");
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

    public String getGameOverText() {
        String message = "Alive";
        if (map.getPlayer().getHealth() > 0) {
            if (map.getPlayer().getInventory().contains("crown")) {
                message = "YOU WON THE GAME";
            }
            return message;
        } else {
            message = "YOU DIED";
        }
        return message;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    public GameMap getMap() {
        return map;
    }


    public static int getVisionRange() {
        return visionRange;
    }

    public static void setVisionRange(int visionRange) {
        GameLogic.visionRange = visionRange;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isDefeat() {
        return defeat;
    }

    public void setDefeat(boolean defeat) {
        this.defeat = defeat;
    }

    public void isGameOver() {
        if (this.getMap().getPlayer().getHealth() <= 0) {
            this.setDefeat(true);
        }
        if (this.getMap().getPlayer().getInventory().contains("crown")) {
            this.setWin(true);
        }
    }
}
