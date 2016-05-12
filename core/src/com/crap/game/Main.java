package com.crap.game;


import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.crap.game.model.*;
import com.crap.game.view.GameView;
import com.crap.game.controller.GameController;
import com.crap.game.view.ProgressView;


public class Main extends com.badlogic.gdx.Game {


    public GameView worldView;
    public GameController controller;
    public Game world;

    BitmapFont progressbar;
    String catchedMascots;


    public void create() {
        worldView = new GameView();
        world = new Game();
        controller = new GameController(worldView, world);
        setScreen(worldView);


    }

    @Override
    public void render () {
        super.render();
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
