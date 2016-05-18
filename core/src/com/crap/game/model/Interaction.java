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
      /*  if(character.getPosition().getX() == x && character.getPosition().getY() == y){
            return true;
        }else if(character.getPosition().getX() == x+playerWidth && character.getPosition().getY() == y){
            return true;

        }else if(character.getPosition().getX() == x && character.getPosition().getY() == y+playerHeight){
            return true;
        }else if(character.getPosition().getX() == x+playerWidth && character.getPosition().getY() == y+playerHeight){
            return true;
        }
        else {
            return false;
        }*/
        return checkEveryPositionForInteraction(character, x, y);
    }

    public boolean checkEveryPositionForInteraction(Character character, float x, float y) {

        return checkIfInteraction(character,x,y)||
                checkIfInteraction(character,x+playerWidth,y)||
                checkIfInteraction(character,x+playerWidth,y+playerHeight)||
                checkIfInteraction(character,x,y+playerHeight) ||
                checkIfInteraction(character,x,y+playerHeight/2)||
                checkIfInteraction(character,x+playerWidth,y+ playerHeight/2);
    }

    public boolean checkIfInteraction(Character character, float playerPositionX, float playerPositionY){

        Float x = character.getPosition().getX();
        Float y = character.getPosition().getY();
        Float width = character.getWidth()/4; //TODO magical constant fix
        Float height = character.getHeight()/4; //TODO magical constant fix

        return collisionModel.checkIfCollide(x,y,width,height,playerPositionX,playerPositionY) ;
    }
}
