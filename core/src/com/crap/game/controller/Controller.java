package com.crap.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.crap.game.model.World;
import com.crap.game.view.WorldView;

/**
 * Created by Lisa on 18/04/16.
 */
public class Controller extends InputAdapter implements Runnable{

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
        this.keyCode = keycode;
        new Thread(this).start();
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        keyPressed = false;
        return false;
    }

    public void run() {
        while (keyPressed) {
            playerController.movePlayer(this.keyCode);
            playerController.update();
            view.render();
        try {
            Thread.sleep(50);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        }
    }
}

