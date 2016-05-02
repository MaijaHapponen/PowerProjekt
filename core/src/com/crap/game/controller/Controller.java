package com.crap.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.crap.game.model.World;
import com.crap.game.view.PlayerView;
import com.crap.game.view.WorldView;

/**
 * Created by Lisa on 18/04/16.
 */
public class Controller extends InputAdapter{

    private WorldView view;
    private World model;
    private OrthographicCamera camera;
    private PlayerController playerController;

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
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        playerController.movePlayer(keycode);
        playerController.update();
        view.render();
        return true;
    }

}

