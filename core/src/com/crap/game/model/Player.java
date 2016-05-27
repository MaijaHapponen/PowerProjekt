package com.crap.game.model;

/**
 * Created by andrea on 2016-04-11.
 */

public class Player extends Character{

//    private Position nextPlayerPos;

    public Player(String name, float x, float y){
        super(name);
        this.position = new Position(x, y);
        super.setNextPlayerPos(new Position());
//        this.nextPlayerPos = new Position();
    }

    public boolean canMoveCameraUp(float y, float boarderTop) {
        return (y < boarderTop);
    }

    public boolean canMoveCameraDown(float y, float boarderBottom){
        return (y > boarderBottom);
    }

    public boolean canMoveCameraLeft(float x, float boarderLeft){
        return (x > boarderLeft);
    }

    public boolean canMoveCameraRight(float x, float boarderRight){
        return (x < boarderRight);
    }

    public void setPosition(float x, float y){
        this.position.setPosition(x,y);
    }

}
