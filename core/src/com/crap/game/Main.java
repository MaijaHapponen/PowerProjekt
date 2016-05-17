package com.crap.game;

import com.crap.game.controller.GameController;
import com.crap.game.controller.MenuController;
import com.crap.game.model.Game;
import com.crap.game.model.State;
import com.crap.game.view.GameView;
import com.crap.game.view.MenuView;

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
        worldView = new GameView();
        controller = new GameController(worldView, world);
        gameMode = true;
    }

    public GameView getWorldView(){
        return this.worldView;
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
