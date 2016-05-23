package com.crap.game.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lisa on 24/04/16.
 */
public class Mascot extends Character{

    private Question question;

    public Mascot(String name){
        super(name);
    }

    public Mascot(String name, Position position){
        super(name, position);
    }


    public void setQuestion(Question question){
        this.question = question;
    }

    public Question getQuestion(){
        return this.question;
    }

}
