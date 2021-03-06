package com.crap.game.model.character.mascotinteraction;

import java.util.List;

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
