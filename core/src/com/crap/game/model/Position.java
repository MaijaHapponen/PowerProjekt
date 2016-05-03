package com.crap.game.model;

/**
 * Created by Lisa on 14/04/16.
 */
public class Position {
    private float x;
    private float y;

    //Constructor
    public Position(){
        this.x = 0;
        this.y = 0;
    }

    //Constructor
    public Position(float x, float y){
        this.x = x;
        this.y = y;
    }

    //Sets the objects position.
    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }

    //Returns the objects x-coordinate.
    public float getX(){
        return this.x;
    }

    //Returns the objects y-coordinate.
    public float getY(){
        return this.y;
    }


}
