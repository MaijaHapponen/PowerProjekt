package com.crap.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.crap.game.model.GameStates;
import com.crap.game.model.InteractMascot;
import com.crap.game.model.Mascot;
import com.crap.game.view.InteractMascotView;
import com.crap.game.model.Character;

/**
 * Created by Maija on 2016-05-18.
 */
public class InteractMascotController extends InputAdapter {

    private InteractMascotView interactMascotView;
    private CRAPController CRAPController;
    private InteractMascot interactMascot;
    private boolean answeredCorrect;

    public InteractMascotController(InteractMascotView interactMascotView, CRAPController CRAPController){
        this.CRAPController = CRAPController;
        this.interactMascot = interactMascotView.getInteractModel();
        this.interactMascotView = interactMascotView;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode){
        if(keycode == Input.Keys.BACKSPACE){
            StateController.updateState(GameStates.PLAY);
            interactMascotView.dispose();
            if(!answeredCorrect) {
                CRAPController.getHumanMascotController().resetWalkAwayState();
            }
        }
        else if(keycode == Input.Keys.ENTER) {
            Character interactingCharacter =
                    CRAPController.getPlayerController().getInteractionController().getInteractingCharacter();


            if (interactMascot.isRightAnswer(interactingCharacter, interactMascot.getCurrentStringNbr())) {
                if(interactingCharacter instanceof Mascot){
                    Mascot caughtMascot = ((Mascot) interactingCharacter);
                    caughtMascot.setCaught(true);
                    CRAPController.mascotCaught(caughtMascot);
                }
                answeredCorrect = true;
                CRAPController.getPlayerController().getInteractionController().getInteractingCharacterView().dispose();
            }
            else{
                answeredCorrect = false;
            }
            interactMascot.setHasAnswered();
        }

        else if(keycode == Input.Keys.DOWN){
            interactMascot.setCurrentString("nextStepDown");
        }

        else if(keycode == Input.Keys.UP){
            interactMascot.setCurrentString("nextStepUp");
        }

        return true;
    }

}
