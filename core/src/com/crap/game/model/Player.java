package com.crap.game.model;
/**
 * Created by andrea on 2016-04-11.
 */

public class Player{

    private Position position;
    private int currentSpeed;
    private int normalSpeed = 2;
    private int slowerSpeed = 1;

    public Player(){
        this.position = new Position(0, 0);
        this.currentSpeed=normalSpeed;
    }

    public Player(float x, float y){
        this.position = new Position(x, y);
        this.currentSpeed = normalSpeed;
    }

    public void moveUp(float height){
        if(!(this.getPosition().getY() > height)) {
            this.position.setPosition(position.getX(), position.getY() + currentSpeed);
        }
    }

    public void moveDown(){
        if(!(this.getPosition().getY() <0)){
            this.position.setPosition(position.getX(), position.getY() - currentSpeed);
        }
    }

    public void moveRight(float width){
        if(!(this.getPosition().getX() > width)) {
            this.position.setPosition(position.getX() + currentSpeed, position.getY());
        }
    }

    public void moveLeft(){
        if(!(this.position.getX() <0)){
            this.position.setPosition(position.getX() - currentSpeed, position.getY());
        }
    }

    public Position getPosition(){return this.position;  }

    public void setPosition(float x, float y){
        this.position.setPosition(x,y);
    }

    public void setCurrentSpeed(int speed){
        this.currentSpeed = speed;
    }

    public int getCurrentSpeed(){
        return currentSpeed;
    }

    public int getNormalSpeed(){
        return this.normalSpeed;
    }

    public int getSlowerSpeed(){
        return this.slowerSpeed;
    }
}
