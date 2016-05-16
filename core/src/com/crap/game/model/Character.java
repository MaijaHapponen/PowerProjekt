package com.crap.game.model;

import java.util.ArrayList;

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

    //Makes the character walk away a few steps.
    public void walkAway(){

        //Random nummber mellan 0-3. om 0: upp om 1: ner om 2: vänster om 3: höger. Kolla om det går att flytta annars
        // testa annan rikting. varje gång lyckad flyttning ---> lägg till 1 till en int variabel och när den är tex. 3
        // är walkAway klart.
        //TODO fixa sen när Beccis pushad upp senaste CollisionModel.

    }

    public String getName(){
        return this.name;
    }
 }
