package com.crap.game;

import com.badlogic.gdx.Game;
import com.crap.game.controller.Controller;
import com.crap.game.view.WorldView;

public class Main extends Game {

    public WorldView worldView;
    public Controller controller;

    public void create() {
        worldView = new WorldView(this);
        controller = new Controller();
        setScreen(worldView);
    }

	@Override
	public void render () {super.render();}

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
