package com.crap.game;

import com.crap.game.controller.game.primary.StateController;

public class Main extends com.badlogic.gdx.Game {

    public StateController stateController;

    public void create() {
        stateController = new StateController(this);
    }

    @Override
    public void render () {
        super.render();
        if(stateController.getGameMode()) stateController.getController().render();
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
