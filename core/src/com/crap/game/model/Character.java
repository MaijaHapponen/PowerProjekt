package com.crap.game.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lisa on 25/04/16.
 */
public abstract class Character{
    private String name;
    private Position position;
    private float width;
    private float height;
    private ArrayList<String> statementList; //TODO ta bort och göra för varje subclass istället?
    private int nbrOfStatements = 3;

    public Character(String name){
        this.name = name;
        this.position = new Position();
        this.statementList = new ArrayList<String>(nbrOfStatements); //TODO fylla listorna med frågor/ledtrådar. Vart?

    }

    public Character(String name, Position position){
        this.name = name;
        this.position = position;
        this.statementList = new ArrayList<String>(nbrOfStatements); //TODO fylla listorna med frågor/ledtrådar. Vart?
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

    //Returns a random of the character's statements.
    public String saySomething(){
        Random rand = new Random();
        int i = rand.nextInt(nbrOfStatements);

        return this.statementList.get(i);
    }

    //Makes the character walk away a few steps.
    public void walkAway(){

        //TODO fixa sen när Beccis pushad upp senaste CollisionModel.

    }

    public String getName(){
        return this.name;
    }

    public ArrayList<String> getStatementList(){
        return this.statementList;
    }
 }
