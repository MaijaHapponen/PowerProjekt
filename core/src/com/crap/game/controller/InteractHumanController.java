package com.crap.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.crap.game.model.Game;
import com.crap.game.model.State;
import com.crap.game.view.InteractHumanView;

/**
 * Created by rebeccafinne on 16-05-23.
 */
public class InteractHumanController extends InputAdapter {

    private InteractHumanController interactHumanController;
    private GameController gameController;

    public InteractHumanController(InteractHumanView interactHumanView, GameController g){
        this.interactHumanController = interactHumanController;
        this.gameController = g;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keyCode){
        if(keyCode == Input.Keys.BACKSPACE){
            StateController.updateState(State.GameStates.PLAY);
        }return true;
    }

}
