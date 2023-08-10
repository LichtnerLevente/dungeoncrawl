package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.ui.UI;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Left implements KeyHandler {
    public static final KeyCode code = KeyCode.LEFT;

    @Override
    public void perform(KeyEvent event, GameMap map, UI ui) {
        if(code.equals(event.getCode())){
            map.getPlayer().move(-1, 0);
            map.getCat().moveCat();
            map.EnemyManager.moveEnemies();
        }
    }
}
