package com.crap.game.model;

/**
 * Created by Lisa on 14/04/16.
 */
public class Position {
    private int x;
    private int y;

    public Position(){
        this.x = 0;
        this.x = 0;
    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
