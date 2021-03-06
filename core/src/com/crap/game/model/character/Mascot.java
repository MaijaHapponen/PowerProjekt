package com.crap.game.model.character;

import com.crap.game.model.information.enums.Worlds;
import com.crap.game.model.primary.Position;
import com.crap.game.model.character.mascotinteraction.Question;

import java.lang.*;

public class Mascot extends Character{


    private boolean isCaught;
    private Question question;

    public Mascot(String name){
        super(name);
        this.isCaught = false;
    }

    public Mascot(String name, Position position, Worlds world){
        super(name, position, world);
        this.isCaught = false;
    }

    public void setQuestion(Question question){
        this.question = question;
    }

    public Question getQuestion() {
        return this.question;
    }

    public void setCaught(boolean b){
        this.isCaught = b;
    }

    public boolean isCaught(){
        return isCaught;
    }
}
