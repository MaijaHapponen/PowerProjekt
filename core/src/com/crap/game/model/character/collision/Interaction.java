package com.crap.game.model.character.collision;

import com.crap.game.model.character.Character;

public class Interaction {

    private CollisionModel collisionModel;
    private float characterWidth;
    private float halfCharacterHeight;

    private boolean isInteracting = false;

    public Interaction(float characterWidth, float halfCharacterHeight) {
        this.collisionModel = new CollisionModel();
        this.characterWidth = characterWidth;
        this.halfCharacterHeight = halfCharacterHeight /2;
    }

    public boolean isInteraction(Character otherCharacter, float characterX, float characterY) {
        return checkEveryPositionForInteraction(otherCharacter, characterX, characterY);
    }

    private boolean checkEveryPositionForInteraction(Character otherCharacter, float characterX, float characterY) {

        return checkIfInteraction(otherCharacter, characterX, characterY) ||
                checkIfInteraction(otherCharacter, characterX + characterWidth, characterY) ||
                checkIfInteraction(otherCharacter, characterX + characterWidth, characterY + halfCharacterHeight) ||
                checkIfInteraction(otherCharacter, characterX, characterY + halfCharacterHeight) ||
                //left side of character
                checkIfInteraction(otherCharacter, characterX, characterY + 3*(halfCharacterHeight / 4)) ||
                checkIfInteraction(otherCharacter, characterX, characterY + halfCharacterHeight / 2) ||
                checkIfInteraction(otherCharacter, characterX, characterY + halfCharacterHeight / 4) ||
                //right side of character
                checkIfInteraction(otherCharacter, characterX + characterWidth, characterY + 3*(halfCharacterHeight / 4)) ||
                checkIfInteraction(otherCharacter, characterX + characterWidth, characterY + halfCharacterHeight / 2) ||
                checkIfInteraction(otherCharacter, characterX + characterWidth, characterY + halfCharacterHeight / 4) ||
                //middle in top and bottom of character
                checkIfInteraction(otherCharacter, characterX + characterWidth / 2, characterY) ||
                checkIfInteraction(otherCharacter, characterX + characterWidth / 2, characterY + halfCharacterHeight);
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
