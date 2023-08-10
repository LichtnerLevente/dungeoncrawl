package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.ui.UI;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Restart implements KeyHandler {
    public static final KeyCode code = KeyCode.R;

    @Override
    public void perform(KeyEvent event, GameMap map, UI ui) {
        if (code.equals(event.getCode())){
            ui.restartGame();
            System.out.println("restart");
        }
    }
}
