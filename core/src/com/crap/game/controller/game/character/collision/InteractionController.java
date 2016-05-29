package com.crap.game.controller.game.character.collision;

import com.crap.game.model.character.Character;
import com.crap.game.model.character.collision.Interaction;
import com.crap.game.model.character.Mascot;
import com.crap.game.view.character.CharacterView;
import com.crap.game.view.primary.CRAPView;

/**
 * Created by andrea on 2016-05-11.
 */
public class InteractionController {

    private Interaction interactionModel;
    private CRAPView CRAPView;
    private Character interactingCharacter;
    private CharacterView interactingCharacterView;

    public InteractionController(CRAPView view){
        this.CRAPView = view;
        this.interactionModel = new Interaction(CRAPView.getPlayerView().getPlayerSpriteWidth(),
                CRAPView.getPlayerView().getPlayerSpriteHeight());
    }

    public boolean isInteractionWithHuman(float x, float y) {
        for (int i = 0; i < CRAPView.getHumansList().size(); i++) {
            CharacterView characterView = CRAPView.getHumansList().get(i);

            if(characterView.getCharacter().getWorld() == CRAPView.getCRAP().getCurrectWorld()) {
                if (interactionModel.isInteraction(characterView.getCharacter(), x, y)) {
                    if (!interactionModel.getIsInteracting()) {
                        setInteractingCharacter(characterView.getCharacter(), characterView);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInteractionWithMascot(float x, float y){
        for(int i = 0; i< CRAPView.getMascotsList().size(); i++){
            CharacterView characterView = CRAPView.getMascotsList().get(i);

            if(characterView.getCharacter().getWorld() == CRAPView.getCRAP().getCurrectWorld() &&
                    !((Mascot) characterView.getCharacter()).isCaught()) {
                if (interactionModel.isInteraction(characterView.getCharacter(), x, y)) {
                    if (!interactionModel.getIsInteracting()) {
                        setInteractingCharacter(characterView.getCharacter(), characterView);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    //Works with the same logic as isInteractionWithHuman and isInterationWithMascot but
    //checks if another character is moving as well
    public boolean isInteractionWithAnotherCharacter(Character characterMoving, float x, float y){
        for (int i = 0; i < CRAPView.getHumansList().size(); i++) {
            CharacterView characterView = CRAPView.getHumansList().get(i);

            if(characterView.getCharacter().getWorld() == CRAPView.getCRAP().getCurrectWorld()) {
                if (interactionModel.isInteraction(characterView.getCharacter(), x, y) &&
                        !characterView.getCharacter().equals(characterMoving)) {
                    return true;
                }
            }
        }
        for (int i = 0; i < CRAPView.getMascotsList().size(); i++) {
            CharacterView characterView = CRAPView.getMascotsList().get(i);

            if (interactionModel.isInteraction(characterView.getCharacter(), x, y) &&
                    !characterView.getCharacter().equals(characterMoving)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInteractionWithPlayer(float x, float y) {
        if (interactionModel.isInteraction(CRAPView.getPlayerView().getPlayer(), x, y)) {
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

    public Interaction getInteractionModel(){
        return this.interactionModel;
    }

}
