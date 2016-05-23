package com.crap.game.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.crap.game.model.State;

/**
 * Created by rebeccafinne on 16-05-23.
 */
public class CheckQuestionController extends InputAdapter{

    
    public CheckQuestionController(){

    }

    public boolean keyDown(int keycode){
        if(keycode == Input.Keys.ENTER){
            StateController.updateState(State.GameStates.PLAY);
        }

        return true;

    }



}
