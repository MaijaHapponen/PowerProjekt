package com.crap.game.model;


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lisa on 25/04/16.
 */
public class Human extends Character {

    private String information;

    public Human(String name){
        super(name);
    }

    public Human(String name, Position position){
        super(name, position);
    }

    public String saySomething(){
        return this.information;
    }

    public void setInformation(String information){
        this.information = information;
    }
}
