package com.crap.game;

import com.badlogic.gdx.Gdx;
import com.crap.game.controller.GameController;
import com.crap.game.view.GameView;
import com.crap.game.model.Game;

public class Main extends com.badlogic.gdx.Game {


    public GameView worldView;
    public GameController controller;
    public Game world;
    public boolean gameMode = false;


    public void create() {
        world = new Game(this);
        world.startMainMenu();
    }

    public void initPlay(){
        worldView = new GameView(world);
        controller = new GameController(worldView, world);
        gameMode = true;
    }
    public void playMode(){
        Gdx.input.setInputProcessor(controller);
        gameMode = true;
    }
    public void setGameMode(boolean b){
        gameMode = b;
    }

    public GameView getWorldView() {
        return this.worldView;
    }

    public Game getWorld() {
        return world;
    }

    @Override
    public void render () {
        super.render();
        if(gameMode) controller.render();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width,height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
