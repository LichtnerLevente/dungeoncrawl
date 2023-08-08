package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Random;

public class Right implements KeyHandler {
    public static final KeyCode code = KeyCode.RIGHT;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if(code.equals(event.getCode())) {
            map.getPlayer().move(1, 0);

            Random random = new Random();
            int randomX = random.nextInt(3) - 1;
            int randomY = random.nextInt(3) - 1;
            map.getCow().move(randomX,randomY);
        }
    }
}
