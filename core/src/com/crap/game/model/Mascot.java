package com.crap.game.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lisa on 24/04/16.
 */
public class Mascot extends Character{
    //private ArrayList<Question> questionsList;
    private Question question;

    public Mascot(String name){
        super(name);
    }

    public Mascot(String name, Position position){
        super(name, position);
    }

    //Returns a random of the character's questions.
    public Question askQuestion(){
       /*
        Random rand = new Random();
        int i = rand.nextInt(questionsList.size());

        return this.questionsList.get(i);
        */
        return this.question;
    }

    public void setQuestion(Question question){
        this.question = question;
    }
}
