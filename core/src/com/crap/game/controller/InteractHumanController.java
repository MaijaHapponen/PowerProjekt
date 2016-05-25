package com.crap.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.crap.game.model.GameStates;
import com.crap.game.model.InteractHuman;
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
            StateController.updateState(GameStates.PLAY);
        }

        if(keyCode == Input.Keys.DOWN){
            interactHuman.setCurrentString("nextStepDown");
        }

        if(keyCode == Input.Keys.UP){
            interactHuman.setCurrentString("nextStepUp");
        }

        if(keyCode == Input.Keys.ENTER){
            if(interactHuman.getCurrentString().equals(interactHuman.getTalkAboutProgramme())){
                interactHuman.setIsProgramme(true);
            }
            else if(interactHuman.getCurrentString().equals(interactHuman.getWhereIsMascot())){
                interactHuman.setIsMascot(true);
            }
            else if(interactHuman.getCurrentString().equals(interactHuman.getExit())){
                StateController.updateState(GameStates.PLAY);
            }
        }

        return true;
    }

}
