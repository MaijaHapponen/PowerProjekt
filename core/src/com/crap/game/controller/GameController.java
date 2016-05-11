package com.crap.game.controller;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.crap.game.model.Game;
import com.crap.game.view.GameView;

/**
 * Created by Lisa on 18/04/16.
 */
public class GameController extends InputAdapter implements ApplicationListener {

    private GameView view;
    private Game model;
    private OrthographicCamera camera;
    private PlayerController playerController;
    private int keyCode;

    public GameController(GameView view, Game world){

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

        this.view = view;
        this.model = world;

        this.view.setPlayer(this.model.player);
        this.view.setCamera(this.camera);

        this.view.setHumans(this.model.humans);
        this.view.setMascots(this.model.mascots);

        this.playerController = new PlayerController(this.view.getPlayerView());

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        this.keyCode=keycode;
        view.render();
        return true;
    }
    @Override
    public void render() {
        if(Gdx.input.isKeyPressed(keyCode)) {
            movePlayer(keyCode);
        }
    }

    public void movePlayer(int keycode){
        playerController.movePlayer(keycode);
    }

    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}

