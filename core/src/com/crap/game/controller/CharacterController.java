package com.crap.game.controller;

import com.crap.game.model.AnimationState;
import com.crap.game.model.Character;
import com.crap.game.view.CharacterView;
import com.crap.game.view.CRAPView;

/**
 * Created by Lisa on 29/05/16.
 */
public abstract class CharacterController {

    private CRAPView CRAPView;
    private Character character;
    private CharacterView characterView;
    private CollisionController collisionController;
    private InteractionController interactionController;

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
