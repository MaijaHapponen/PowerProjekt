package com.crap.game.controller;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.crap.game.model.Game;
import com.crap.game.view.GameView;

/**
 * Created by Lisa on 18/04/16.
 */
public class GameController extends InputAdapter implements ApplicationListener {


    public enum GameState{STARTMENU, PLAY, INTERACT, GAMEOVER}

    public  GameState state;
    private GameView view;
    private Game model;
    private OrthographicCamera camera;
    private PlayerController playerController;
    private WorldController worldController;
    private int keyCode;

    private boolean keyPressed = false;

    public GameController(GameView view, Game game){

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

        this.view = view;
        this.model = game;

        this.state = GameState.STARTMENU;

        this.view.setPlayer(this.model.player);
        this.view.setCamera(this.camera);

        this.view.setHumans(this.model.humans);
        this.view.setMascots(this.model.mascots);

        this.playerController = new PlayerController(this.view.getPlayerView());
        this.worldController = new WorldController(this.view.getWorldView(), model);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        this.keyCode=keycode;
        view.render();
        return true;
    }

    public void update(){
        switch (state) {
            case STARTMENU:
                //updateStart();
                break;
            case PLAY:
                    //updatePlay();
                break;
            case INTERACT:
                //updateInteract();
                break;
            case GAMEOVER:
                //gameOver = true;
                //updateGameOver();
                break;
        }
    }

    public void movePlayer(int keycode){
        this.keyCode = keycode;
        playerController.movePlayer(keyCode);
    }

    @Override
    public void render(){
        if(Gdx.input.isKeyPressed(keyCode)) {
            movePlayer(keyCode);
        }
    }


    @Override
    public void create() {}

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {}
}

