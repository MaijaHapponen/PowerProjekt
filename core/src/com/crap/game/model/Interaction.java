package com.crap.game.model;

/**
 * Created by rebeccafinne on 2016-04-26.
 */
public class Interaction {
    private CollisionModel collisionModel;
    private float playerWidth;
    private float playerHeight;

    public Interaction(float playerWidth, float playerHeight) {

        this.collisionModel = new CollisionModel();
        this.playerWidth = playerWidth;
        this.playerHeight = playerHeight;
    }

    public boolean isInteraction(Character character, float x, float y) {
        return checkEveryPositionForInteraction(character, x, y);
    }

    public boolean checkEveryPositionForInteraction(Character character, float x, float y) {

        return checkIfInteraction(character, x, y) ||
                checkIfInteraction(character, x + playerWidth, y) ||
                checkIfInteraction(character, x + playerWidth, y + playerHeight) ||
                checkIfInteraction(character, x, y + playerHeight) ||
                checkIfInteraction(character, x, y + playerHeight / 2) ||
                checkIfInteraction(character, x + playerWidth, y + playerHeight / 2) ||
                checkIfInteraction(character, x + playerWidth / 2, y) ||
                checkIfInteraction(character, x + playerWidth / 2, y + playerHeight);
    }


    public boolean checkIfInteraction(Character character, float playerPositionX, float playerPositionY) {

        Float x = character.getPosition().getX();
        Float y = character.getPosition().getY();
        Float width = character.getWidth();
        Float height = character.getHeight();

        return collisionModel.checkIfCollide(x, y, width, height, playerPositionX, playerPositionY);
    }



}
