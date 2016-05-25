package com.crap.game.model;

import static com.crap.game.model.Constants.*;

/**
 * Created by Lisa on 25/04/16.
 */
public abstract class Character{

    private String name;
    protected Position position;

    private float width;
    private float height;
    private Game.Worlds world;

    private float speed;

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

    public void setWidthAndHeight(float width, float height){
        this.width=width;
        this.height=height;
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
