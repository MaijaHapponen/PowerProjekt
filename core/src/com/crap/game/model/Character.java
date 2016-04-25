package com.crap.game.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lisa on 25/04/16.
 */
public abstract class Character {

    private Position position;
    private ArrayList<String> statementList;
    private int nbrOfStatements = 3;

    //Constructor
    public Character(){
        this.position = new Position();
        this.statementList = new ArrayList<String>(nbrOfStatements); //TODO fylla listorna med frågor/ledtrådar.
        //TODO borde ha någon typ av "utseende" också.
    }

    //Constructor
    public Character(Position position){
        this.position = position;
        this.statementList = new ArrayList<String>(nbrOfStatements); //TODO fylla listorna med frågor/ledtrådar.
        //TODO borde ha någon typ av "utseende" också.
    }

    //Returns a random of the character's statements.
    public String saySomething(){
        Random rand = new Random();
        int i = rand.nextInt(nbrOfStatements);

        return this.statementList.get(i);
    }
}
