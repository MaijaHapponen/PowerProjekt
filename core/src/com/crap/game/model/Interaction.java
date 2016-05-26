package com.crap.game.model;

/**
 * Created by rebeccafinne on 2016-04-26.
 */
public class Interaction {
    private CollisionModel collisionModel;
    private float otherCharacterWidth;
    private float otherCharacterHeight;

    private boolean isInteracting = false;

    public Interaction(float playerWidth, float playerHeight) {
        this.collisionModel = new CollisionModel();
        this.otherCharacterWidth = playerWidth;
        this.otherCharacterHeight = playerHeight;
    }

    public boolean isInteraction(Character character, float x, float y) {
        return checkEveryPositionForInteraction(character, x, y);
    }

    private boolean checkEveryPositionForInteraction(Character character, float x, float y) {

        return checkIfInteraction(character, x, y) ||
                checkIfInteraction(character, x + otherCharacterWidth, y) ||
                checkIfInteraction(character, x + otherCharacterWidth, y + otherCharacterHeight) ||
                checkIfInteraction(character, x, y + otherCharacterHeight) ||
                //nextStepLeft side of character
                checkIfInteraction(character, x, y + 3*(otherCharacterHeight / 4)) ||
                checkIfInteraction(character, x, y + otherCharacterHeight / 2) ||
                checkIfInteraction(character, x, y + otherCharacterHeight / 4) ||
                //nextStepRight side of character
                checkIfInteraction(character, x + otherCharacterWidth, y + 3*(otherCharacterHeight / 4)) ||
                checkIfInteraction(character, x + otherCharacterWidth, y + otherCharacterHeight / 2) ||
                checkIfInteraction(character, x + otherCharacterWidth, y + otherCharacterHeight / 4) ||
                //middle in top and bottom of character
                checkIfInteraction(character, x + otherCharacterWidth / 2, y) ||
                checkIfInteraction(character, x + otherCharacterWidth / 2, y + otherCharacterHeight);
    }


    private boolean checkIfInteraction(Character character, float thisX, float thisY) {

        //TODO: magic numbers for collision to work remove?
        Float width = character.getWidth();
        Float halfHeight = character.getHeight()/2;
        Float x = character.getPosition().getX();
        Float y = character.getPosition().getY()+halfHeight;

        return collisionModel.checkIfCollide(x, y, width, halfHeight, thisX, thisY);
    }

    public void setIsInteracting(boolean state){
        isInteracting = state;
    }

    public boolean getIsInteracting(){
        return this.isInteracting;
    }

}
