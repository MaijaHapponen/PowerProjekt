package com.crap.game.model;

/**
 * Created by rebeccafinne on 2016-04-26.
 */
public class Interaction {
    private CollisionModel collisionModel;
    private float otherCharacterWidth;
    private float otherCharacterHeight;

    private boolean isInteracting = false;

    public Interaction(float otherCharacterWidth, float otherCharacterHeight) {
        this.collisionModel = new CollisionModel();
        this.otherCharacterWidth = otherCharacterWidth;
        this.otherCharacterHeight = otherCharacterHeight;
    }

    public boolean isInteraction(Character otherCharacter, float characterX, float characterY) {
        return checkEveryPositionForInteraction(otherCharacter, characterX, characterY);
    }

    private boolean checkEveryPositionForInteraction(Character otherCharacter, float characterX, float characterY) {

        return checkIfInteraction(otherCharacter, characterX, characterY) ||
                checkIfInteraction(otherCharacter, characterX + otherCharacterWidth, characterY) ||
                checkIfInteraction(otherCharacter, characterX + otherCharacterWidth, characterY + otherCharacterHeight) ||
                checkIfInteraction(otherCharacter, characterX, characterY + otherCharacterHeight) ||
                //nextStepLeft side of character
                checkIfInteraction(otherCharacter, characterX, characterY + 3*(otherCharacterHeight / 4)) ||
                checkIfInteraction(otherCharacter, characterX, characterY + otherCharacterHeight / 2) ||
                checkIfInteraction(otherCharacter, characterX, characterY + otherCharacterHeight / 4) ||
                //nextStepRight side of character
                checkIfInteraction(otherCharacter, characterX + otherCharacterWidth, characterY + 3*(otherCharacterHeight / 4)) ||
                checkIfInteraction(otherCharacter, characterX + otherCharacterWidth, characterY + otherCharacterHeight / 2) ||
                checkIfInteraction(otherCharacter, characterX + otherCharacterWidth, characterY + otherCharacterHeight / 4) ||
                //middle in top and bottom of character
                checkIfInteraction(otherCharacter, characterX + otherCharacterWidth / 2, characterY) ||
                checkIfInteraction(otherCharacter, characterX + otherCharacterWidth / 2, characterY + otherCharacterHeight);
    }


    private boolean checkIfInteraction(Character otherCharacter, float characterX, float characterY) {

        Float width = otherCharacter.getWidth();
        Float height = otherCharacter.getHeight();
        Float x = otherCharacter.getPosition().getX();
        Float y = otherCharacter.getPosition().getY();

        return collisionModel.checkIfCollide(x, y, width, height, characterX, characterY);
    }

    public void setIsInteracting(boolean state){
        isInteracting = state;
    }

    public boolean getIsInteracting(){
        return this.isInteracting;
    }

}
