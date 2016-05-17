package com.crap.game.controller;

import com.badlogic.gdx.InputAdapter;
import com.crap.game.model.Character;
import com.crap.game.model.Game;
import com.crap.game.view.CharacterView;

public class CharacterController extends InputAdapter{

    private CharacterView view;
    private Game game;
    private Character character;
//    private OrthographicCamera camera;
//    private PlayerController playerController;

    public CharacterController(CharacterView view, Game game, Character character){

        this.view = view;
        this.game = game;
        this.character = character;

        /*
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
        this.view.setCamera(camera);*/
    }
/*
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

