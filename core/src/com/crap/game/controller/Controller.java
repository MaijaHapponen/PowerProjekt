package com.crap.game.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import static com.crap.game.view.WorldView.*;

/**
 * Created by Lisa on 18/04/16.
 * Edited by Andrea on 2016-05-22
 */
public class Controller implements InputProcessor {

    @Override public boolean keyDown(int keycode) {
        return false;
    }

    @Override public boolean keyUp(int keycode) {
        player.movePlayer(String.valueOf(keycode));
        int x = player.getPosition().getX();
        int y = player.getPosition().getY();
        camera.lookAt(x,y,0);
        return true;
    }

    @Override public boolean keyTyped(char character) {

        return false;
    }

    @Override public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override public boolean scrolled(int amount) {
        return false;
    }
}