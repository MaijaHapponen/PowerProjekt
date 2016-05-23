package com.crap.game.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.crap.game.model.State;
import com.crap.game.view.CheckQuestionView;

/**
 * Created by rebeccafinne on 16-05-23.
 */
public class CheckQuestionController extends InputAdapter{

    //TODO when in checkQuestionView interactController is used
    private CheckQuestionView checkQuestionView;
    
    public CheckQuestionController(){

        this.checkQuestionView = new CheckQuestionView();
    }

    @Override
    public boolean keyDown(int keycode){
        if(keycode == Input.Keys.ENTER){
            StateController.updateState(State.GameStates.PLAY);
            checkQuestionView.dispose();
            return true;
        }

        return false;

    }

    //TODO make a method that checks if the answer is right or wrong, maybe in a modelclass?



}
