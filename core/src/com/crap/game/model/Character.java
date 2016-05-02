package com.crap.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lisa on 25/04/16.
 */
public abstract class Character{
    //TODO: have some kind or String to determine which character we have? Can also decide texture
    private Position position;
    private ArrayList<String> statementList;
    private int nbrOfStatements = 3;

    //Constructor
    public Character(){
        this.position = new Position();
        this.statementList = new ArrayList<String>(nbrOfStatements); //TODO fylla listorna med frågor/ledtrådar. Vart?

    }

    //Constructor
    public Character(Position position){
        this.position = position;
        this.statementList = new ArrayList<String>(nbrOfStatements); //TODO fylla listorna med frågor/ledtrådar. Vart?
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
}
