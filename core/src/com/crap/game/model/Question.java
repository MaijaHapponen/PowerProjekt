package com.crap.game.model;

/**
 * Created by Lisa on 15/05/16.
 */
public class Question {
    private String question;
    private String[] alternatives;
    private String correctAnswer;

    //The correct answer will be the first item in the alternatives list.
    public Question(String question, String[] alternatives){
        this.question = question;
        this.alternatives = alternatives;
        this.correctAnswer = alternatives[0];
    }
}
