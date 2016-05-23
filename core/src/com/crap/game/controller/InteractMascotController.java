package com.crap.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.crap.game.model.InteractMascot;
import com.crap.game.model.State;
import com.crap.game.view.InteractMascotView;

/**
 * Created by Maija on 2016-05-18.
 */
public class InteractMascotController extends InputAdapter {

    private InteractMascotView interactMascotView;
    private GameController gameController;
    private InteractMascot interactMascot;
//TODO    private CharacterController characterController;

    public InteractMascotController(InteractMascotView interactMascotView, GameController gameController){
        this.gameController = gameController;
        this.interactMascot = interactMascotView.getInteractModel();
        this.interactMascotView = interactMascotView;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode){
        if(keycode == Input.Keys.BACKSPACE){
            StateController.updateState(State.GameStates.PLAY);
            interactMascotView.dispose();
        }else if(keycode == Input.Keys.ENTER){
            //checkIfRightAnswer(interactMascotView.answerChoosen(interactMascot.getCurrentLabel()));
            StateController.updateState(State.GameStates.CHECKQUESTION);
            interactMascotView.dispose();
        }else if(keycode == Input.Keys.DOWN){
            interactMascot.setCurrentLabel("down");
        }else if(keycode == Input.Keys.UP){
            interactMascot.setCurrentLabel("up");
        }
        return true;
    }
}
