package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Cow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Random;

public class Down implements KeyHandler {
    public static final KeyCode code = KeyCode.DOWN;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (code.equals(event.getCode())) {
            map.getPlayer().move(0, 1);

            Random random = new Random();
            int randomX = random.nextInt(3) - 1;
            int randomY = random.nextInt(3) - 1;
            map.getCow().move(randomX,randomY);
        }
    }
}
