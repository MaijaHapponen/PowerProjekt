package com.crap.game.model;

/**
 * Created by andrea on 2016-04-11.
 */

public class Player extends Character{

    public Player(String name){
        super(name);
    }

    public Player(String name, float x, float y){
        super(name);
        this.position = new Position(x, y);
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

    public Position getPosition(){return this.position;  }

    public void setPosition(float x, float y){
        this.position.setPosition(x,y);
    }

}
