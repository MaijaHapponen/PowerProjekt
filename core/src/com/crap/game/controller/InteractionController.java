package com.crap.game.controller;

import com.crap.game.model.*;
import com.crap.game.model.Character;
import com.crap.game.view.CharacterView;
import com.crap.game.view.GameView;

/**
 * Created by andrea on 2016-05-11.
 */
public class InteractionController {
    private Interaction interactionModel;
    private GameView gameView;
    private Character interactingCharacter;
    private CharacterView interactingCharacterView;
    private static boolean isInteracting = false;

    public InteractionController(GameView view){
        this.gameView = view;
        this.interactionModel = new Interaction(gameView.getPlayerView().getPlayerSpriteWidth(),
                gameView.getPlayerView().getPlayerSpriteHeight());
    }

    public boolean isInteractionWithHuman(float x, float y) {
        for (int i = 0; i < gameView.getHumansList().size(); i++) {
            CharacterView characterView = gameView.getHumansList().get(i);

            if (interactionModel.isInteraction(characterView.getCharacter(), x, y)) {
                if(!isInteracting) {
                    setInteractingCharacter(characterView.getCharacter(), characterView);
                }
                return true;
            }
        }
        return false;
    }

    public boolean isInteractionWithMascot(float x, float y){
        for(int i=0; i< gameView.getMascotsList().size(); i++){
            CharacterView characterView = gameView.getMascotsList().get(i);

            if(interactionModel.isInteraction(characterView.getCharacter(),x, y)){
                if(!isInteracting) {
                    setInteractingCharacter(characterView.getCharacter(), characterView);
                }
                return true;
            }
        }
        return false;
    }

    public boolean isInteractionWithAnotherCharacter(Character characterMoving, float x, float y){
        for (int i = 0; i < gameView.getHumansList().size(); i++) {
            CharacterView characterView = gameView.getHumansList().get(i);

            if (interactionModel.isInteraction(characterView.getCharacter(), x, y) &&
                    !characterView.getCharacter().equals(characterMoving)) {
                return true;
            }
        }
        for (int i = 0; i < gameView.getMascotsList().size(); i++) {
            CharacterView characterView = gameView.getMascotsList().get(i);

            if (interactionModel.isInteraction(characterView.getCharacter(), x, y) &&
                    !characterView.getCharacter().equals(characterMoving)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInteractionWithPlayer(float x, float y) {
        if (interactionModel.isInteraction(gameView.getPlayerView().getPlayer(), x, y)) {
            return true;
        }
        return false;
    }

    public void setInteractingCharacter(Character character, CharacterView characterView){
        this.interactingCharacter = character;
        this.interactingCharacterView = characterView;
    }

    public Character getInteractingCharacter(){
        return this.interactingCharacter;
    }

    public CharacterView getInteractingCharacterView(){
        return this.interactingCharacterView;
    }

    public boolean getIsInteracting(){
        return isInteracting;
    }

    public void setIsInteracting(boolean state){
        isInteracting = state;
    }
}
