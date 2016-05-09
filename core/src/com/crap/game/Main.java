package com.crap.game;

import com.badlogic.gdx.Game;
import com.crap.game.controller.Controller;
import com.crap.game.model.World;
import com.crap.game.view.ProgressView;
import com.crap.game.view.WorldView;

public class Main extends Game {

    public WorldView worldView;
    public Controller controller;
    public World world;
 ;

    public void create() {
        worldView = new WorldView();
        world = new World();
        controller = new Controller(worldView, world);

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
