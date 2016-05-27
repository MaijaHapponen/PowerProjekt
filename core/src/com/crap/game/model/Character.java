package com.crap.game.model;

import static com.crap.game.model.Constants.*;
import java.util.Random;

/**
 * Created by Lisa on 25/04/16.
 */
public abstract class Character{

    private String name;
    protected Position position;

    private float width;
    private float height;
    private Game.Worlds world;

    private Direction walkAwayDirection;
    private Direction lastDirection;

    private float speed;
    private Position nextPlayerPos;

    public void setNextPlayerPos(Position pos){
        nextPlayerPos = pos;
    }

    public Character(){
        this.position = new Position();
    }

    public Character(String name){
        this.speed = NORMAL_SPEED;
        this.name = name;
        this.position = new Position(0,0);
    }

    public Character(String name, Position position, Game.Worlds world){
        this.speed = NORMAL_SPEED;
        this.name = name;
        this.position = position;
        this.world = world;
    }

    public void decideNewDirection(){
        Random rand = new Random();
        int i = rand.nextInt(4);
        switch (i){
            case 0:
                if(lastDirection != Direction.DOWN) {
                    setWalkAwayDirection(Direction.UP);
                }
                else{
                    decideNewDirection();
                }
                break;
            case 1:
                if(lastDirection != Direction.UP) {
                    setWalkAwayDirection(Direction.DOWN);
                }
                else{
                    decideNewDirection();
                }
                break;
            case 2:
                if(lastDirection != Direction.RIGHT) {
                    setWalkAwayDirection(Direction.LEFT);
                }
                else{
                    decideNewDirection();
                }
                break;
            case 3:
                if(lastDirection != Direction.LEFT) {
                    setWalkAwayDirection(Direction.RIGHT);
                }
                else{
                    decideNewDirection();
                }
                break;
        }
    }

    public float getX(){
        return getPosition().getX();
    }

    public float getY(){
        return getPosition().getY();
    }

    public void moveUp(float mapHeight){
        if(!(this.getPosition().getY() > mapHeight)) {
            getPosition().setPosition(getX(), getY() + speed);
        }
    }

    public void moveDown(){
        if(!(this.getPosition().getY() < Constants.PROGRESS_BAR_HEIGHT)) {
            getPosition().setPosition(getX(), getY() - speed);
        }
    }

    public void moveLeft(){
        if(!(this.position.getX() <0)) {
            getPosition().setPosition(getX() - speed, getY());
        }
    }

    public void moveRight(float mapWidth){
        if(!(this.getPosition().getX() > mapWidth)) {
            getPosition().setPosition(getX() + speed, getY());
        }
    }

    public boolean positionOutOfBounds(float mapWidth, float mapHeight){
        if(getX() < mapWidth || getY() < mapHeight){
            return false;
        }
        return true;
    }

    public void updateDirections(){
        this.lastDirection = walkAwayDirection;
        this.walkAwayDirection = Direction.NO_DIRECTION;
    }

    public Direction getLastDirection(){
        return this.lastDirection;
    }

    public void changeDirection(int walkAwayState){
        if(walkAwayState == Constants.WALK_AWAY_LENGTH/3 || walkAwayState ==
                (Constants.WALK_AWAY_LENGTH/3)*2){
            updateDirections();
        }
        if (this.walkAwayDirection == null || this.walkAwayDirection == Direction.NO_DIRECTION){
            decideNewDirection();
        }
    }

    public void setWidthAndHeight(float width, float height){
        this.width=width;
        this.height=height;
    }

    public Direction getWalkAwayDirection(){
        return  this.walkAwayDirection;
    }

    public void setWalkAwayDirection(Direction walkAwayDirection){
        this.walkAwayDirection = walkAwayDirection;
    }

    public float getWidth(){
        return this.width;
    }

    public float getHeight(){
        return this.height;
    }

    public Position getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    public Game.Worlds getWorld(){
        return this.world;
    }

    public void setWorld(Game.Worlds world) {
        this.world = world;
    }

    public void setNormalSpeed(){
        this.speed = NORMAL_SPEED;
    }

    public void setSlowerSpeed(){
        this.speed = SLOWER_SPEED;
    }

    public float getSpeed(){
        return this.speed;
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

 }
