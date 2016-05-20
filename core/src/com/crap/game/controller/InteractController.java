package com.crap.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.crap.game.model.Interact;
import com.crap.game.model.State;
import com.crap.game.view.InteractView;

/**
 * Created by Maija on 2016-05-18.
 */
public class InteractController extends InputAdapter {

    private InteractView interactView;
    private GameController gameController;
    private Interact interact;
//TODO    private CharacterController characterController;

    public InteractController(InteractView interactView, GameController gameController){
        this.gameController = gameController;
        this.interact = interactView.getInteractModel();
        this.interactView = interactView;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode){
        if(keycode == Input.Keys.BACKSPACE){
            StateController.updateState(State.GameStates.PLAY);
            interactView.dispose();
        }else if(keycode == Input.Keys.ENTER){
            //checkIfRightAnswer(interactView.answerChoosen(interact.getCurrentLabel()));
            StateController.updateState(State.GameStates.CHECKQUESTION);
            interactView.dispose();
        }else if(keycode == Input.Keys.DOWN){
            interact.setCurrentLabel("down");
        }else if(keycode == Input.Keys.UP){
            interact.setCurrentLabel("up");
            //TODO this.gameController.getCharacterController().interactsWith( **character, characterView** );
            this.gameController.getCharacterController().resetWalkAwayState();
        }
        return true;
    }
}
