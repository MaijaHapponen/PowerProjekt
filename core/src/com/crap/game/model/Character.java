package com.crap.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lisa on 25/04/16.
 */
public abstract class Character extends Sprite{

    private Sprite sprite;
    private Position position;
    private Texture texture;
    private ArrayList<String> statementList;
    private int nbrOfStatements = 3;

    //Constructor
    public Character(){
        this.position = new Position();
        this.statementList = new ArrayList<String>(nbrOfStatements); //TODO fylla listorna med frågor/ledtrådar.
        this.texture = new Texture("characters/giant.png"); //TODO Ska såklart inte var Kalle senare.
        this.sprite = new Sprite(texture);
        sprite.setPosition(position.getX(), position.getY());
    }

    //Constructor
    public Character(Position position){
        this.position = position;
        this.statementList = new ArrayList<String>(nbrOfStatements); //TODO fylla listorna med frågor/ledtrådar. Vart?
        this.texture = new Texture("characters/giant.png"); //TODO Ska såklart inte var jättar senare.
        this.sprite = new Sprite(texture);
        sprite.setPosition(position.getX(), position.getY());
    }

    //Constructor
    public Character(Position position, Texture texture){
        this.position = position;
        this.statementList = new ArrayList<String>(nbrOfStatements); //TODO fylla listorna med frågor/ledtrådar. Vart?
        this.texture = texture;
        this.sprite = new Sprite(texture);
        sprite.setPosition(position.getX(), position.getY());
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

    //Returns the characters Sprite object.
    public Sprite getSprite() {
        return this.sprite; }
}
