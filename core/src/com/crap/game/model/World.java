package com.crap.game.model;

/**
 * Created by Lisa on 24/04/16.
 */
public class World {

    private Progress progress;

    //Constructor
    public World(){
        this.progress = new Progress();
    }

    //Checks if the game is over.
    public boolean isGameOver(){
        if(progress.areAllMascotsCaught()){
            return true;
        }
        return false;
    }

}
