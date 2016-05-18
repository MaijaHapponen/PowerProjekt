package com.crap.game.model;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionModel {

    public enum tileType {WALKABLE_TILE, SOLID_TILE, SLOWER_TILE, NEW_WORLD}; //The different types of tiles

    private boolean blocked;
    private boolean slow;
    private boolean newWorld;
    private boolean interaction;

    public CollisionModel(){
        blocked=false;
        slow=false;
        newWorld=false;
        interaction=false;
    }

    public boolean isBlocked(){
        return blocked;
    }

    public boolean isSlow(){
        return slow;
    }

    public boolean isNewWorld() {
        return newWorld;
    }

    public boolean checkIfCollide(float x, float y, float width, float height, float playerPositionX, float playerPositionY) {
        return (playerPositionX > x && playerPositionX < x+width) && (playerPositionY>y && playerPositionY<y+height) ;
    }

    public void setTypeOfTile(tileType tile){
        if(tile==tileType.SOLID_TILE){
            blocked=true;
            slow=false;
            newWorld=false;
        }
        else if(tile==tileType.SLOWER_TILE){
            blocked=false;
            slow=true;
            newWorld=false;
        }
        else if(tile==tileType.NEW_WORLD){
            blocked=true;
            slow=false;
            newWorld=true;

        }
        else{
            blocked = false;
            slow=false;
            newWorld=false;
        }
    }
}
