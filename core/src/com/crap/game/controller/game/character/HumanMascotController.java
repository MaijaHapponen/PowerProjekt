package com.crap.game.controller.game.character;

import com.crap.game.model.information.enums.AnimationState;
import com.crap.game.model.character.Character;
import com.crap.game.model.information.Constants;
import com.crap.game.model.information.enums.Direction;
import com.crap.game.view.character.CharacterView;
import com.crap.game.view.primary.CRAPView;

public class HumanMascotController extends CharacterController {

    private int walkAwayState = Constants.WALK_AWAY_LENGTH;

    public HumanMascotController(CRAPView CRAPView){
        super(CRAPView);
    }

    public void interactsWith(Character character, CharacterView characterView){
        collisionController.setCharacterWidthAndHeight(character.getWidth(),
                character.getHeight());
        setCharacter(character);
        setCharacterView(characterView);
    }

    public void move(Direction direction){
        float movement = getCharacter().getSpeed()*Constants.NORMAL_SPEED;

        switch (direction) {
            case UP:
                if (isPositionEmpty(getCharacter().getPosition().getX(), getCharacter().getPosition().getY() +
                        movement)) {
                    this.moveUp();
                } else {
                    getCharacter().updateDirections();
                }
                break;
            case DOWN:
                if (isPositionEmpty(getCharacter().getPosition().getX(), getCharacter().getPosition().getY() -
                        movement)) {
                    this.moveDown();
                } else {
                    getCharacter().updateDirections();
                }
                break;
            case LEFT:
                if (isPositionEmpty(getCharacter().getPosition().getX() - movement,
                        getCharacter().getPosition().getY())) {
                    this.moveLeft();
                } else {
                    getCharacter().updateDirections();
                }
                break;
            case RIGHT:
                if (isPositionEmpty(getCharacter().getPosition().getX() + movement, getCharacter().getPosition().getY())) {
                    this.moveRight();
                } else {
                    getCharacter().updateDirections();
                }
                break;
        }
        this.getCharacterView().updateAnimation();
    }

    //Returns true if there is a collision.
    public boolean checkIfCollision(float x, float y) {
        if (collisionController.isCollison(x, y) || collisionController.isNewWorld(x,y) ||
                interactionController.isInteractionWithAnotherCharacter(getCharacter(), x, y) ||
                //TODO: perhaps remove or explain
                interactionController.isInteractionWithPlayer(x, y + (getCharacter().getHeight()/2))) {
            return true;
        }
        return false;
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
        if(getCharacter().positionOutOfBounds(getCRAPView().getWorldWidth(), getCRAPView().getWorldHeight())){
            return false;
        }
        if(checkIfCollision(x, y) ){
            return false;
        }
        return true;
    }

    public void stopWalkingAnimation(){
        switch (getCharacter().getWalkAwayDirection()){
            case UP:
                getCharacterView().setAnimationState(AnimationState.STANDING_BACK);
                break;
            case DOWN:
                getCharacterView().setAnimationState(AnimationState.STANDING_FRONT);
                break;
            case LEFT:
                getCharacterView().setAnimationState(AnimationState.STANDING_LEFT);
                break;
            case RIGHT:
                getCharacterView().setAnimationState(AnimationState.STANDING_RIGHT);
                break;
            case NO_DIRECTION:
                break;
        }
        getCharacterView().updateAnimation();
        interactionController.getInteractionModel().setIsInteracting(false);
    }

    public void walkAwayOneStep(){
        getCharacter().changeDirection(this.walkAwayState);
        this.move(getCharacter().getWalkAwayDirection());

        if(walkAwayState == Constants.WALK_AWAY_LENGTH -1 && !(getCharacter().getWalkAwayDirection() ==
                Direction.NO_DIRECTION)){
            stopWalkingAnimation();
        }
        updateSprite();
        walkAwayState++;
    }
}