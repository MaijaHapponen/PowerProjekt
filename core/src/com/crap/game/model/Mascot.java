package com.crap.game.model;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Lisa on 24/04/16.
 */
public class Mascot extends Character{

    //Constructor
    public Mascot(){
        super();
    }

    //Constructor
    public Mascot(Position position){
        super(position);
    }

    //Constructor
    public Mascot(Position position, Texture texture){
        super(position, texture);
    }
}
