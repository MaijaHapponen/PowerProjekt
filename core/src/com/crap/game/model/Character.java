package com.crap.game.model;

import java.util.Random;

/**
 * Created by Lisa on 25/04/16.
 */
public abstract class Character{

    public enum Direction{UP, DOWN, LEFT, RIGHT, NO_DIRECTION}

    private String name;
    protected Position position;
    private float width;
    private float height;
    private Game.Worlds world;

    private Character.Direction walkAwayDirection;
    private Character.Direction lastDirection;

    private float speed;

    private float normalSpeed = 2;
    private float slowerSpeed = 1;

    public Character(){
        this.position = new Position();
    }

    public Character(String name){
        this.speed = normalSpeed;
        this.name = name;
        this.position = new Position(0,0);
    }

    public Character(String name, Position position, Game.Worlds world){
        this.speed = normalSpeed;
        this.name = name;
        this.position = position;
        this.world = world;
    }

    public void decideNewDirection(){
        Random rand = new Random();
        int i = rand.nextInt(4);
        switch (i){
            case 0:
                if(lastDirection != Character.Direction.DOWN) {
                    walkAwayDirection = Character.Direction.UP;
                }
                else{
                    decideNewDirection();
                }
                break;
            case 1:
                if(lastDirection != Character.Direction.UP) {
                    walkAwayDirection = Character.Direction.DOWN;
                }
                else{
                    decideNewDirection();
                }
                break;
            case 2:
                if(lastDirection != Character.Direction.RIGHT) {
                    walkAwayDirection = Character.Direction.LEFT;
                }
                else{
                    decideNewDirection();
                }
                break;
            case 3:
                if(lastDirection != Character.Direction.LEFT) {
                    walkAwayDirection = Character.Direction.RIGHT;
                }
                else{
                    decideNewDirection();
                }
                break;
        }
    }

    public void updateDirections(){
        lastDirection = walkAwayDirection;
        walkAwayDirection = Direction.NO_DIRECTION;
    }

    public void changeDirection(int walkAwayLength, int walkAwayState){
        if(walkAwayState == walkAwayLength/3 || walkAwayState ==
                (walkAwayLength/3)*2){
            this.lastDirection = this.walkAwayDirection;
            this.walkAwayDirection = Direction.NO_DIRECTION;
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

    public void setWalkAwayDirection(Direction direction){
        this.walkAwayDirection = direction;
    }

    public void setLastDirection(Direction direction){
        this.lastDirection = direction;
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

    public void setNormalSpeed(){
        this.speed = normalSpeed;
    }

    public void setSlowerSpeed(){
        this.speed = slowerSpeed;
    }

    public float getSpeed(){
        return this.speed;
    }
 }
