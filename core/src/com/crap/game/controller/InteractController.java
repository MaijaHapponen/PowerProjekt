package com.crap.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.crap.game.model.State;
import com.crap.game.view.InteractView;

/**
 * Created by Maija on 2016-05-18.
 */
public class InteractController extends InputAdapter {

    private InteractView interactView;
    private GameController gameController;
//TODO    private CharacterController characterController;

    public InteractController(InteractView interactView, GameController gameController){
        this.gameController = gameController;
        this.interactView = interactView;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode){
        if(keycode == Input.Keys.ENTER){
            StateController.updateState(State.GameStates.PLAY);
            interactView.dispose();
            gameController.getCharacterController().walkAway();
            //TODO            characterController.walkAway();
        }
        return true;
    }
}
