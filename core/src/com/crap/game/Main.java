package com.crap.game;

import com.crap.game.controller.GameController;
import com.crap.game.model.Game;
import com.crap.game.view.GameView;

public class Main extends com.badlogic.gdx.Game {

    public GameView worldView;
    public GameController controller;
    public Game world;

    public void create() {
        worldView = new GameView();
        world = new Game();
        controller = new GameController(worldView, world);
        setScreen(worldView);
    }

    public GameView getWorldView(){
        return this.worldView;
    }

    @Override
    public void render () {super.render();
    controller.render();}

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
