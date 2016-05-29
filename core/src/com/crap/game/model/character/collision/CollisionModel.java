package com.crap.game.model.character.collision;

import com.crap.game.model.information.enums.TileType;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionModel {

    private boolean blocked;
    private boolean slow;
    private boolean newWorld;

    public CollisionModel(){
        blocked=false;
        slow=false;
        newWorld=false;
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

    public void setTypeOfTile(TileType tile){
        if(tile==TileType.SOLID_TILE){
            blocked=true;
            slow=false;
            newWorld=false;
        }
        else if(tile==TileType.SLOWER_TILE){
            blocked=false;
            slow=true;
            newWorld=false;
        }
        else if(tile==TileType.NEW_WORLD){
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
