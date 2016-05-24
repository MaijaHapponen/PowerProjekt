package com.crap.game.model;

/**
 * Created by Lisa on 24/04/16.
 */
public class Mascot extends Character{

    private boolean isCaught;

    private Question question;

    public Mascot(String name){
        super(name);
        this.isCaught = false;
    }

    public Mascot(String name, Position position){
        super(name, position);
        this.isCaught = false;
    }


    public void setQuestion(Question question){
        this.question = question;
    }

    public Question getQuestion(){
        return this.question;
    }

    public void setCaught(boolean b){
        isCaught = b;
    }

    public boolean isCaught(){
        return this.isCaught;
    }
}
