package com.crap.game.controller;

import com.crap.game.model.AnimationState;
import com.crap.game.model.Character;
import com.crap.game.view.CharacterView;
import com.crap.game.view.GameView;

/**
 * Created by Lisa on 29/05/16.
 */
public abstract class CharacterController {

    private GameView gameView;
    private Character character;
    private CharacterView characterView;
    private CollisionController collisionController;
    private InteractionController interactionController;

    public CharacterController(GameView gameView){
        this.gameView = gameView;
        this.collisionController = new CollisionController(gameView.getWorld());
        interactionController = new InteractionController(gameView);
    }

    public CharacterController(GameView gameView, Character character, CharacterView characterView){
        this.character = character;
        this.characterView = characterView;
        this.gameView = gameView;
        this.collisionController = new CollisionController(gameView.getWorld());
        interactionController = new InteractionController(gameView);
    }

    public void updateCollisionController(){
        this.collisionController = new CollisionController(gameView.getWorld());
        if(characterView != null) {
            collisionController.setCharacterWidthAndHeight(character.getWidth(),
                    character.getHeight());
        }
    }

    public void moveUp() {
        character.moveUp(gameView.getWorldHeight());
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
        character.moveRight(gameView.getWorldWidth());
        this.characterView.setAnimationState(AnimationState.WALKING_RIGHT);
    }

    public void updateSprite() {
        characterView.getSprite().setPosition(this.character.getPosition().getX(), this.character.getPosition().getY());
    }

    public GameView getGameView() {
        return this.gameView;
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
