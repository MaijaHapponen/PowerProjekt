package com.crap.game.controller;

import com.crap.game.model.*;
import com.crap.game.model.Character;
import com.crap.game.view.GameView;

/**
 * Created by andrea on 2016-05-11.
 */
public class InteractionController {
    private Interaction interactionModel;
    private GameView gameView;
    private Character interactingCharacter;

    public InteractionController(GameView view){
        this.gameView = view;
        this.interactionModel = new Interaction(gameView.getPlayerView().getPlayerSpriteWidth(),
                gameView.getPlayerView().getPlayerSpriteHeight());
    }

    public boolean isInteractionWithHuman(float x, float y) {
        for (int i = 0; i < gameView.getHumansList().size(); i++) {
            Character character = gameView.getHumansList().get(i).getCharacter();

            if (interactionModel.isInteraction(character, x, y)) {
                setInteractingCharacter(character);
                return true;
            }
        }
        return false;
    }

    public boolean isInteractionWithMascot(float x, float y){
        for(int i=0; i< gameView.getMascotsList().size(); i++){
            Character character = gameView.getMascotsList().get(i).getCharacter();

            if(interactionModel.isInteraction(character,x, y)){
                setInteractingCharacter(character);
                return true;
            }
        }
        return false;
    }

    public void setInteractingCharacter(Character character){
        this.interactingCharacter = character;
    }

    public Character getInteractingCharacter(){
        return this.interactingCharacter;
    }

}
