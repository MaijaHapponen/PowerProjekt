package com.crap.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.crap.game.model.World;
import com.crap.game.view.WorldView;

/**
 * Created by Lisa on 18/04/16.
 * Edited by Andrea on 2016-05-22
 */
public class Controller implements  InputProcessor{

    private WorldView view;
    private World model;
    private OrthographicCamera camera;

    public Controller(WorldView view, World world){

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

        this.view = view;
        this.model = world;

        this.view.setPlayer(model.player);
        this.view.setCamera(camera);
        //this.view.setCollision(model.collision);
        //this.view.setWorld(model.map);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        model.player.movePlayer(keycode);
        model.player.update();
        view.render();
        return true;
    }

    @Override public boolean keyTyped(char character) { return false; }

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

