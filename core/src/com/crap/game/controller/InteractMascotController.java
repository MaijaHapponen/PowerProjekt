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
    private GameController gameController;
    private InteractMascot interactMascot;

    private boolean answeredCorrect;

    public InteractMascotController(InteractMascotView interactMascotView, GameController gameController){
        this.gameController = gameController;
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
                gameController.getHumanMascotController().resetWalkAwayState();
            }
        }

        else if(keycode == Input.Keys.ENTER) {
            Character interactingCharacter =
                    gameController.getPlayerController().getInteractionController().getInteractingCharacter();

            if (interactMascot.isRightAnswer(interactingCharacter, interactMascot.getCurrentStringNbr())) {

                if(interactingCharacter instanceof Mascot){
                    Mascot caughtMascot = ((Mascot) interactingCharacter);
                    caughtMascot.setCaught(true);
                    gameController.mascotCaught(caughtMascot);
                }
                answeredCorrect = true;
                gameController.getPlayerController().getInteractionController().getInteractingCharacterView().dispose();
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
