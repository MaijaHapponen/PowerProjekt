package com.crap.game.model;

/**
 * Created by rebeccafinne on 2016-04-26.
 */
public class Interaction {
    private CollisionModel collisionModel;
    private float playerWidth;
    private float playerHeight;
    private Position playerClose;

    public Interaction(float playerWidth, float playerHeight){

        this.collisionModel = new CollisionModel();
        this.playerWidth=playerWidth;
        this.playerHeight=playerHeight;
    }

    public boolean isInteraction(Character character, float x, float y) {
        return checkEveryPositionForInteraction(character, x, y);
    }

    public boolean isInteraction(Player player, float x, float y) {
        return checkEveryPositionForInteraction(player, x, y);
    }

    public boolean checkEveryPositionForInteraction(Character character, float x, float y) {

        return checkIfInteraction(character,x,y)||
                checkIfInteraction(character,x+playerWidth,y)||
                checkIfInteraction(character,x+playerWidth,y+playerHeight)||
                checkIfInteraction(character,x,y+playerHeight) ||
                checkIfInteraction(character,x,y+playerHeight/2)||
                checkIfInteraction(character,x+playerWidth,y+ playerHeight/2) ||
                checkIfInteraction(character,x+playerWidth/2,y) ||
                checkIfInteraction(character,x+playerWidth/2,y+ playerHeight);
    }

    public boolean checkEveryPositionForInteraction(Player player, float x, float y) {

        return checkIfInteraction(player,x,y)||
                checkIfInteraction(player,x+playerWidth,y)||
                checkIfInteraction(player,x+playerWidth,y+playerHeight)||
                checkIfInteraction(player,x,y+playerHeight) ||
                checkIfInteraction(player,x,y+playerHeight/2)||
                checkIfInteraction(player,x+playerWidth,y+ playerHeight/2) ||
                checkIfInteraction(player,x+playerWidth/2,y) ||
                checkIfInteraction(player,x+playerWidth/2,y+ playerHeight);
    }

    public boolean checkIfInteraction(Character character, float playerPositionX, float playerPositionY){

        Float x = character.getPosition().getX();
        Float y = character.getPosition().getY();
        Float width = character.getWidth()/4; //TODO magical constant fix
        Float height = character.getHeight()/4; //TODO magical constant fix

        return collisionModel.checkIfCollide(x,y,width,height,playerPositionX,playerPositionY) ;
    }

    public boolean checkIfInteraction(Player player, float playerPositionX, float playerPositionY){

        Float x = player.getPosition().getX();
        Float y = player.getPosition().getY();
        Float width = playerWidth;
        Float height = playerHeight;

        return collisionModel.checkIfCollide(x,y,width,height,playerPositionX,playerPositionY) ;
    }
}
