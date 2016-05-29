package com.crap.game.controller.game.character;

import com.crap.game.controller.game.character.collision.CollisionController;
import com.crap.game.controller.game.character.collision.InteractionController;
import com.crap.game.model.information.enums.AnimationState;
import com.crap.game.model.character.Character;
import com.crap.game.view.character.CharacterView;
import com.crap.game.view.primary.CRAPView;

/**
 * Created by Lisa on 29/05/16.
 */
public abstract class CharacterController {

    private CRAPView CRAPView;
    private Character character;
    protected CharacterView characterView;
    protected CollisionController collisionController;
    protected InteractionController interactionController;

    public CharacterController(CRAPView CRAPView){
        this.CRAPView = CRAPView;
        this.collisionController = new CollisionController(CRAPView.getWorld());
        interactionController = new InteractionController(CRAPView);
    }

    public CharacterController(CRAPView CRAPView, Character character, CharacterView characterView){
        this.character = character;
        this.characterView = characterView;
        this.CRAPView = CRAPView;
        this.collisionController = new CollisionController(CRAPView.getWorld());
        interactionController = new InteractionController(CRAPView);
    }

    public void updateCollisionController(){
        this.collisionController = new CollisionController(CRAPView.getWorld());
        if(characterView != null) {
            collisionController.setCharacterWidthAndHeight(character.getWidth(),
                    character.getHeight());
        }
    }

    public void moveUp() {
        character.moveUp(CRAPView.getWorldHeight());
        this.characterView.setAnimationState(AnimationState.WALKING_BACK);
    }

    public void moveDown(){
        character.moveDown();
        this.characterView.setAnimationState(AnimationState.WALKING_FRONT);
    }

    public void moveLeft(){
        character.moveLeft();
        this.characterView.setAnimationState(AnimationState.WALKING_LEFT);
    }

    public void moveRight(){
        character.moveRight(CRAPView.getWorldWidth());
        this.characterView.setAnimationState(AnimationState.WALKING_RIGHT);
    }

    public void updateSprite() {
        characterView.getSprite().setPosition(this.character.getPosition().getX(), this.character.getPosition().getY());
    }

    public CRAPView getCRAPView() {
        return this.CRAPView;
    }

    public Character getCharacter(){
        return this.character;
    }

    public void setCharacter(Character character){
        this.character = character;
    }

    public InteractionController getInteractionController(){
        return this.interactionController;
    }

    public CollisionController getCollisionController(){
        return this.collisionController;
    }

    public CharacterView getCharacterView(){
        return this.characterView;
    }

    public void setCharacterView(CharacterView characterView){
        this.characterView = characterView;
    }
}
