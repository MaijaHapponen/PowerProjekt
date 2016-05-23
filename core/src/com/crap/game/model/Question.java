package com.crap.game.model;

import java.util.List;

/**
 * Created by Lisa on 15/05/16.
 */
public class Question {
    private String question;
    private List<String> alternatives;
    private int correctAnswer;

    public Question(String question, List<String> alternatives, int correctAnswerNumber){
        this.question = question;
        this.alternatives = alternatives;
        this.correctAnswer = correctAnswerNumber;
    }

    public List<String> getAlternatives(){
        return this.alternatives;
    }

    public String getQuestion(){
        return this.question;
    }

    public int getCorrectAnswer(){
        return this.correctAnswer;
    }
}
