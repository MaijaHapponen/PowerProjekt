package com.crap.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.crap.game.model.World;
import com.crap.game.view.CharacterView;

public class CharacterController extends InputAdapter{
/*
    private CharacterView view;
    private World game;
    private OrthographicCamera camera;
    private PlayerController playerController;

    public CharacterController(CharacterView view, World game){

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        this.view = view;
        this.game = game;
        this.camera = new OrthographicCamera();

        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

        this.view.setPlayer(game.player);
        this.view.setTexture(playerController.getTexture());
        this.view.setSprite(playerController.getSprite());
        this.view.setPosition(game.player.getPosition());
        this.view.setCamera(camera);
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

*/
}

