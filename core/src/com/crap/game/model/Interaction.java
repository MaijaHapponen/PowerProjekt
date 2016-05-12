package com.crap.game.model;

/**
 * Created by rebeccafinne on 2016-04-26.
 */
public class Interaction {
    private CollisionModel collisionModel;
    private float playerWidth;
    private float playerHeight;
    private Character character;

    public void setCharacter(Character character){
        this.character=character;
    }

    public Interaction(float playerWidth, float playerHeight){
        this.collisionModel = new CollisionModel();
        this.playerWidth=playerWidth;
        this.playerHeight=playerHeight;
    }

    public boolean isInteraction(float x, float y) {
        return checkEveryPositionForInteraction(x,y);
    }

    public boolean checkEveryPositionForInteraction(float x, float y) {

        return checkIfInteraction(x,y)||checkIfInteraction(x+playerWidth,y)||
                checkIfInteraction(x+playerWidth,y+playerHeight)||checkIfInteraction(x,y+playerHeight)
                ||checkIfInteraction(x,y+playerHeight/2)||checkIfInteraction(x+playerWidth,y+ playerHeight/2);

    }

    public boolean checkIfInteraction( float playerPositionX, float playerPositionY){

        Float x = character.getPosition().getX();
        Float y = character.getPosition().getY();
        Float width = character.getWidth();
        Float height = character.getHeight();

        return collisionModel.checkIfCollide(x,y,width,height,playerPositionX,playerPositionY) ;

    }


}
