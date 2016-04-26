package com.crap.game.model;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Lisa on 25/04/16.
 */
public class Human extends Character {

    //Constructor
    public Human(){
        super();
    }

    //Constructor
    public Human(Position position){
        super(position);
    }

    //Constructor
    public Human(Position position, Texture texture){
        super(position, texture);
    }
}
