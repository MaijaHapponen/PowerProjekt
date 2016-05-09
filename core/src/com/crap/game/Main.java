package com.crap.game;

import com.crap.game.model.World;
import com.crap.game.view.GameView;


import com.crap.game.controller.GameController;
import com.crap.game.controller.MenuController;
import com.crap.game.model.Game;
import com.crap.game.view.GameView;
import com.crap.game.view.MenuView;



public class Main extends com.badlogic.gdx.Game {


    public GameView worldView;
    public GameController controller;
    public Game world;
    public boolean gameMode = false;

    public void create() {
        MenuView menuView = new MenuView(this);
        new MenuController(menuView);
        setScreen(menuView);
    }

    public void gameModeOn(){
        worldView = new GameView(this);
        world = new Game();
        controller = new GameController(worldView, world);
        setScreen(worldView);
        gameMode = true;
    }

    public GameView getWorldView() {
        return this.worldView;


    }

    @Override
    public void render () {

        controller.render();


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
