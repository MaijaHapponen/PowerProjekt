package com.crap.game.model;
/**
 * Created by andrea on 2016-04-11.
 */

public class Player{

    private Position position;
    //private CollisionModel collision = new CollisionModel();
    private int normalSpeed = 4;
    private int slowerSpeed = 2;

    public Player(){
        this.position = new Position(250, 250);

    }

    public Player(int x, int y){
        this.position = new Position(x, y);

    }

    public void moveUp(){

        if(this.position.getY() < 1000){// && collision.getTypeOfTile(position.getX(), position.getY()) == CollisionModel.typeOfTile.SLOWER_TILE){
            this.position.setPosition(position.getX(), position.getY() + slowerSpeed);
        }
        if(this.position.getY() < 1000) { //TODO should be changed to the max height of the world later.
            this.position.setPosition(position.getX(), position.getY() + normalSpeed);
        }

    }

    public void moveDown(){

        if(this.position.getY() > 0 ){//&& collision.getTypeOfTile(position.getX(), position.getY()) == CollisionModel.typeOfTile.SLOWER_TILE){
            this.position.setPosition(position.getX(), position.getY() - slowerSpeed);
        }
        if(this.position.getY() > 0) {
            this.position.setPosition(position.getX(), position.getY() - normalSpeed);
        }

    }

    public void moveRight(){

        if(this.position.getX() < 1000) {// && collision.getTypeOfTile(position.getX(), position.getY()) == CollisionModel.typeOfTile.SLOWER_TILE){
            this.position.setPosition(position.getX() + slowerSpeed, position.getY() );
        }
        if(this.position.getX() < 1000) { //TODO should be changed to the max width of the world later.
            this.position.setPosition(position.getX() + normalSpeed, position.getY());
        }
    }

    public void moveLeft(){

        if(this.position.getX() > 0){ //&& collision.getTypeOfTile(position.getX(), position.getY()) == CollisionModel.typeOfTile.SLOWER_TILE){
            this.position.setPosition(position.getX() - slowerSpeed, position.getY());
        }
        if(this.position.getX() > 0){
            this.position.setPosition(position.getX() - normalSpeed, position.getY());
        }
    }
    public Position getPosition(){return this.position;  }

    public int getNormalSpeed(){
        return this.normalSpeed;
    }

    public int getSlowerSpeed(){
        return this.slowerSpeed;
    }

}
