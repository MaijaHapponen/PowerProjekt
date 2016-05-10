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
        this.position = new Position(250, 250);
        this.currentSpeed=normalSpeed;
    }

    public Player(float x, float y){
        this.position = new Position(x, y);
        this.currentSpeed = normalSpeed;
    }

    public void moveUp(){

        if(!isOutOfBounds()) {
            this.position.setPosition(position.getX(), position.getY() + currentSpeed);
        }


    }

    public void moveDown(){

        if(!isOutOfBounds()){
            this.position.setPosition(position.getX(), position.getY() - currentSpeed);
        }


    }

    public void moveRight(){

        if(!isOutOfBounds()) {
            this.position.setPosition(position.getX() + currentSpeed, position.getY());
        }

    }

    public void moveLeft(){
        if(!isOutOfBounds()){
            this.position.setPosition(position.getX() - currentSpeed, position.getY());
        }

    }

    public boolean isOutOfBounds(){
        //TODO should be changed to the max width of the world later.
        return this.position.getX() < 0 || this.position.getX() > 1000 ||
                this.position.getY() < 0  || this.position.getY() > 1000;
    }
    public Position getPosition(){return this.position;  }


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
