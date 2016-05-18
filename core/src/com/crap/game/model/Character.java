package com.crap.game.model;

/**
 * Created by Lisa on 25/04/16.
 */
public abstract class Character{
    private String name;
    private Position position;
    private float width;
    private float height;

    public Character(String name){
        this.name = name;
        this.position = new Position();
    }

    public Character(String name, Position position){
        this.name = name;
        this.position = position;
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
 }
