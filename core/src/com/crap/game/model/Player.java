package com.crap.game.model;

/**
 * Created by andrea on 2016-04-11.
 */

public class Player extends Character{

    private Position nextPlayerPos;

    public Player(String name){
        super(name);
        this.nextPlayerPos = new Position();
    }

    public Player(String name, float x, float y){
        super(name);
        this.position = new Position(x, y);
        this.nextPlayerPos = new Position();
    }

    public void moveUp(float height){
        if(!(this.getPosition().getY() > height)) {
            this.position.setPosition(position.getX(), position.getY() + this.getSpeed());
        }
    }

    public void moveDown(){
        if(!(this.getPosition().getY() <0)){
            this.position.setPosition(position.getX(), position.getY() - this.getSpeed());
        }
    }

    public void moveRight(float width){
        if(!(this.getPosition().getX() > width)) {
            this.position.setPosition(position.getX() + this.getSpeed(), position.getY());
        }
    }

    public void moveLeft(){
        if(!(this.position.getX() <0)){
            this.position.setPosition(position.getX() - this.getSpeed(), position.getY());
        }
    }

    public Position up(){
        nextPlayerPos.setPosition(getPosition().getX(), (getPosition().getY() + getSpeed()));
        return nextPlayerPos;
    }

    public Position down(){
        nextPlayerPos.setPosition(getPosition().getX(), getPosition().getY() - getSpeed());
        return nextPlayerPos;
    }

    public Position left(){
        nextPlayerPos.setPosition(getPosition().getX() - getSpeed(), getPosition().getY());
        return nextPlayerPos;
    }

    public Position right(){
        nextPlayerPos.setPosition(getPosition().getX() + getSpeed(), getPosition().getY());
        return nextPlayerPos;
    }

    public Position getPosition(){return this.position;  }

    public void setPosition(float x, float y){
        this.position.setPosition(x,y);
    }

}
