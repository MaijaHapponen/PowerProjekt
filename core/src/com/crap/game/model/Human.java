package com.crap.game.model;


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lisa on 25/04/16.
 */
public class Human extends Character {
    private ArrayList<Information> informationList;

    public Human(String name){
        super(name);
    }

    public Human(String name, Position position){
        super(name, position);
    }

    //Returns a random of the character's statements/clues.
    public Information saySomething(){
        Random rand = new Random();
        int i = rand.nextInt(informationList.size());

        return this.informationList.get(i);
    }
}
