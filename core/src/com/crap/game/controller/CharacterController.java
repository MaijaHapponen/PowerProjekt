package com.crap.game.controller;

import com.crap.game.model.AnimationState;
import com.crap.game.model.Character;
import com.crap.game.model.Constants;
import com.crap.game.model.Direction;
import com.crap.game.view.CharacterView;
import com.crap.game.view.GameView;

public class CharacterController{

    private GameView gameView;
    private Character character;
    private CharacterView characterView;
    private CollisionController collisionController;
    private InteractionController interactionController;
    private int walkAwayState = Constants.WALK_AWAY_LENGTH;

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

    public void move(Direction direction){
        float movement = character.getSpeed()*Constants.NORMAL_SPEED;

        switch (direction) {
            case UP:
                if (isPositionEmpty(character.getPosition().getX(), character.getPosition().getY() + movement)) {
                    this.moveUp();
                } else {
                    character.updateDirections();
                }
                break;
            case DOWN:
                if (isPositionEmpty(character.getPosition().getX(), character.getPosition().getY() - movement)) {
                    this.moveDown();
                } else {
                    character.updateDirections();
                }
                break;
            case LEFT:
                if (isPositionEmpty(character.getPosition().getX() - movement, character.getPosition().getY())) {
                    this.moveLeft();
                } else {
                    character.updateDirections();
                }
                break;
            case RIGHT:
                if (isPositionEmpty(character.getPosition().getX() + movement, character.getPosition().getY())) {
                    this.moveRight();
                } else {
                    character.updateDirections();
                }
                break;
        }
        this.characterView.updateAnimation();
    }

    //Returns true if there is a collision.
    public boolean checkIfCollision(float x, float y) {
        if (collisionController.isCollison(x, y) || collisionController.isNewWorld(x,y) ||
                interactionController.isInteractionWithAnotherCharacter(this.character, x, y) ||
                //TODO: perhaps remove or explain
                interactionController.isInteractionWithPlayer(x, y + (character.getHeight()/2))) {
            return true;
        }
        return false;
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

    public void resetWalkAwayState(){
        this.walkAwayState = 0;
    }

    public void walkAway(Character character, CharacterView characterView){
        if(walkAwayState<Constants.WALK_AWAY_LENGTH){
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
                this.characterView.setAnimationState(AnimationState.STANDING_BACK);
                break;
            case DOWN:
                this.characterView.setAnimationState(AnimationState.STANDING_FRONT);
                break;
            case LEFT:
                this.characterView.setAnimationState(AnimationState.STANDING_LEFT);
                break;
            case RIGHT:
                this.characterView.setAnimationState(AnimationState.STANDING_RIGHT);
                break;
            case NO_DIRECTION:
                break;
        }
        this.characterView.updateAnimation();
        interactionController.getInteractionModel().setIsInteracting(false);
    }

    public void walkAwayOneStep(){
        character.changeDirection(Constants.WALK_AWAY_LENGTH, this.walkAwayState);
        this.move(character.getWalkAwayDirection());

        if(walkAwayState == Constants.WALK_AWAY_LENGTH -1 && !(character.getWalkAwayDirection() ==
                Direction.NO_DIRECTION)){
            stopWalkingAnimation();
        }
        updateSprite();
        walkAwayState++;
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

    public void setCollisionController(CollisionController collisionController){
        this.collisionController = collisionController;
    }
}