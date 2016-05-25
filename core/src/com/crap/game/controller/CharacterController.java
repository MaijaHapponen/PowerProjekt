package com.crap.game.controller;

import com.crap.game.model.Character;
import com.crap.game.model.Direction;
import com.crap.game.view.CharacterView;
import com.crap.game.view.GameView;
import com.crap.game.view.PlayerView;

public class CharacterController{

    private GameView gameView;
    private Character character;
    private CharacterView characterView;
    private CollisionController collisionController;
    private InteractionController interactionController;
    private int walkAwayLength = 60; //TODO move to constant class.
    private int walkAwayState = walkAwayLength;

    public CharacterController(GameView view){
        this.gameView = view;
        this.collisionController = new CollisionController(view.getWorld());
        interactionController = new InteractionController(view);
    }

    public void interactsWith(Character character, CharacterView characterView){
        collisionController.setPlayerWidthAndHeight(characterView.getCharacterSpriteWidth(),
                characterView.getCharacterSpriteHeight());
        this.character = character;
        this.characterView = characterView;
    }

    public void updateCollisionController(){
        this.collisionController = new CollisionController(gameView.getWorld());
        if(characterView != null) {
            collisionController.setPlayerWidthAndHeight(characterView.getCharacterSpriteWidth(),
                    characterView.getCharacterSpriteHeight());
        }
    }

    public void move(Character.Direction direction){
        float movement = character.getSpeed()*2;

        switch (direction){
            case UP:
                if(isPositionEmpty(character.getPosition().getX(), character.getPosition().getY()+movement)){
                    this.moveUp();
                }
                else{
                    character.updateDirections();
                }
                break;
            case DOWN:
                if(isPositionEmpty(character.getPosition().getX(), character.getPosition().getY()-movement)){
                    this.moveDown();
                }
                else{
                    character.updateDirections();
                }
                break;
            case LEFT:
                if(isPositionEmpty(character.getPosition().getX()-movement, character.getPosition().getY())){
                    this.moveLeft();
                }
                else{
                    character.updateDirections();
                }
                break;
            case RIGHT:
                if(isPositionEmpty(character.getPosition().getX()+movement, character.getPosition().getY())){
                    this.moveRight();
                }
                else{
                    character.updateDirections();
                }
                break;
        }
    }

    //Returns true if there is a collision.
    public boolean checkIfCollision(float x, float y) {
        if (collisionController.isCollison(x, y) || collisionController.isNewWorld(x,y) ||
                interactionController.isInteractionWithAnotherCharacter(this.character, x, y) ||
                interactionController.isInteractionWithPlayer(x, y)) {
            return true;
        }

        if (interactionController.isInteractionWithPlayer(x, y)){
            return true;
        }
        return false;
    }

    public void moveUp() {
        character.moveUp(gameView.getWorldHeight());
        this.characterView.setAnimationState(PlayerView.AnimationState.WALKING_BACK);
        this.characterView.updateAnimation();
    }

    public void moveDown(){
        character.moveDown();
        this.characterView.setAnimationState(PlayerView.AnimationState.WALKING_FRONT);
        this.characterView.updateAnimation();
    }

    public void moveLeft(){
        character.moveLeft();
        this.characterView.setAnimationState(PlayerView.AnimationState.WALKING_LEFT);
        this.characterView.updateAnimation();
    }

    public void moveRight(){
        character.moveRight(gameView.getWorldWidth());
        this.characterView.setAnimationState(PlayerView.AnimationState.WALKING_RIGHT);
        this.characterView.updateAnimation();
    }

    public void updateSprite() {
        characterView.getSprite().setPosition(this.character.getPosition().getX(),
                this.character.getPosition().getY());
    }

    public void resetWalkAwayState(){
        this.walkAwayState = 0;
    }

    public void walkAway(Character character, CharacterView characterView){
        if(walkAwayState<walkAwayLength){
            interactionController.getInteractionModel().setIsInteracting(true);
            interactsWith(character, characterView);
            walkAwayOneStep();
        }
    }

    public boolean isPositionEmpty(float x, float y){
        if(character.positionOutOfBounds(gameView.getWorldWidth(), gameView.getWorldHeight())){
            return false;
        }
        if(checkIfCollision(x, y) ){
            return false;
        }
        return true;
    }

    public void stopWalkingAnimation(){
        switch (character.getWalkAwayDirection()){
            case UP:
                this.characterView.setAnimationState(PlayerView.AnimationState.STANDING_BACK);
                this.characterView.updateAnimation();
                break;
            case DOWN:
                this.characterView.setAnimationState(PlayerView.AnimationState.STANDING_FRONT);
                this.characterView.updateAnimation();
                break;
            case LEFT:
                this.characterView.setAnimationState(PlayerView.AnimationState.STANDING_LEFT);
                this.characterView.updateAnimation();
                break;
            case RIGHT:
                this.characterView.setAnimationState(PlayerView.AnimationState.STANDING_RIGHT);
                this.characterView.updateAnimation();
                break;
            case NO_DIRECTION:
                break;
        }
        interactionController.getInteractionModel().setIsInteracting(false);
    }

    public void walkAwayOneStep(){
        character.changeDirection(this.walkAwayLength, this.walkAwayState);
        this.move(character.getWalkAwayDirection());

        if(walkAwayState == walkAwayLength-1 && !(character.getWalkAwayDirection()== Character.Direction.NO_DIRECTION)){
            stopWalkingAnimation();
        }
        updateSprite();
        walkAwayState++;
    }
}