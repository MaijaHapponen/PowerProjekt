package com.crap.game.model;

/**
 * Created by andrea on 2016-04-11.
 */

public class Player extends Character{

    private Position nextPlayerPos;

    public Player(String name, float x, float y){
        super(name);
        this.position = new Position(x, y);
        this.nextPlayerPos = new Position();
    }

    public Position nextStepUp(){
        nextPlayerPos.setPosition(getPosition().getX(), (getPosition().getY() + getSpeed()));
        return nextPlayerPos;
    }

    public Position nextStepDown(){
        nextPlayerPos.setPosition(getPosition().getX(), getPosition().getY() - getSpeed());
        return nextPlayerPos;
    }

    public Position nextStepLeft(){
        nextPlayerPos.setPosition(getPosition().getX() - getSpeed(), getPosition().getY());
        return nextPlayerPos;
    }

    public Position nextStepRight(){
        nextPlayerPos.setPosition(getPosition().getX() + getSpeed(), getPosition().getY());
        return nextPlayerPos;
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

    public Position getPosition(){return this.position;  }

    public void setPosition(float x, float y){
        this.position.setPosition(x,y);
    }

}
