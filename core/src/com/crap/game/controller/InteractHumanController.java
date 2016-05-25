package com.crap.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.crap.game.model.InteractHuman;
import com.crap.game.model.State;
import com.crap.game.view.InteractHumanView;

/**
 * Created by rebeccafinne on 16-05-23.
 */
public class InteractHumanController extends InputAdapter {

    private InteractHumanView interactHumanView;
    private InteractHuman interactHuman;

    public InteractHumanController(InteractHumanView interactHumanView){
        this.interactHumanView = interactHumanView;
        interactHuman = interactHumanView.getInteractHuman();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keyCode){

        if(keyCode == Input.Keys.BACKSPACE){
            StateController.updateState(State.GameStates.PLAY);
        }

        if(keyCode == Input.Keys.DOWN){
            interactHuman.setCurrentString("down");
        }

        if(keyCode == Input.Keys.UP){
            interactHuman.setCurrentString("up");
        }

        if(keyCode == Input.Keys.ENTER){
            if(interactHuman.getCurrentString().equals(interactHumanView.getTalkAboutProgramme())){
                interactHumanView.setIsProgramme(true);
            }
            else if(interactHuman.getCurrentString().equals(interactHumanView.getWhereIsMascot())){
                interactHumanView.setIsMascot(true);
            }
            else if(interactHuman.getCurrentString().equals(interactHumanView.getExit())){
                StateController.updateState(State.GameStates.PLAY);
            }
        }

        return true;
    }

}
