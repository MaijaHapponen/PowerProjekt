package com.crap.game.model;

/**
 * Created by Lisa on 15/05/16.
 */
public class Question {
    private String question;
    private String[] alternatives;
    private String correctAnswer;

    public Question(String question, String[] alternatives, int correctAnswerNumber){
        this.question = question;
        this.alternatives = alternatives;
        this.correctAnswer = alternatives[correctAnswerNumber];
    }
}
