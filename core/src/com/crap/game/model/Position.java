package com.crap.game.model;

/**
 * Created by Lisa on 14/04/16.
 */
public class Position {
    private int x;
    private int y;

    //Constructor
    public Position(){
        this.x = 0;
        this.x = 0;
    }

    //Constructor
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    //Sets the objects position.
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    //Returns the objects x-coordinate.
    public int getX(){
        return this.x;
    }

    //Returns the objects y-coordinate.
    public int getY(){
        return this.y;
    }


}
