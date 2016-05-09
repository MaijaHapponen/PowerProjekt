package com.crap.game.model;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionModel {

    public enum tileType {WALKABLE_TILE, SOLID_TILE, SLOWER_TILE}; //The different types of tiles

    private boolean blocked;
    private boolean slow;

    public CollisionModel(){
        blocked=false;
        slow=false;
    }

    public boolean isBlocked(){
        return blocked;
    }

    public boolean isSlow(){
        return slow;
    }

    public void setTypeOfTile(tileType tile){
        if(tile==tileType.SOLID_TILE){
            blocked=true;
            slow=false;
        }else if(tile==tileType.SLOWER_TILE){
            blocked=false;
            slow=true;
        }else{
            blocked = false;
            slow=false;
        }
    }


}
