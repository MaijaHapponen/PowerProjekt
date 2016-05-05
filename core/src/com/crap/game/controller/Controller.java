package com.crap.game.controller;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.crap.game.model.World;
import com.crap.game.view.WorldView;

/**
 * Created by Lisa on 18/04/16.
 */
public class Controller extends InputAdapter implements ApplicationListener {

    private WorldView view;
    private World model;
    private OrthographicCamera camera;
    private PlayerController playerController;
    private int keyCode;

    private boolean keyPressed = false;

    public Controller(WorldView view, World world){

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

        this.view = view;
        this.model = world;

        this.view.setPlayer(this.model.player);
        this.view.setCamera(this.camera);
        //this.view.setCollision(model.collision);
        //this.view.setWorld(model.map);

        this.view.setHumans(this.model.humans);
        this.view.setMascots(this.model.mascots);

        this.playerController = new PlayerController(this.view.getPlayerView());

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        keyPressed = true;
        this.keyCode=keycode;
        if(Gdx.input.isKeyPressed(keyCode)){
            movePlayer(keyCode);
        }
        view.render();

        //new Thread(this).start();
        return true;
    }

    public void update(){


    }

    public void movePlayer(int keycode){
        this.keyCode = keycode;
        playerController.movePlayer(keyCode);
        playerController.update();
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        if(Gdx.input.isKeyPressed(keyCode)) {
            keyDown(keyCode);
        }
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

