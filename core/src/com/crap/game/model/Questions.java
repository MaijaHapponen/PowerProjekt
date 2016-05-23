package com.crap.game.model;

import java.util.ArrayList;

/**
 * Created by andrea on 2016-05-23.
 */
public class Questions {

    public Questions(ArrayList<Mascot> mascots){
        setQuestions(mascots);
    }

    public void setQuestions(ArrayList<Mascot> mascots) {

        //TODO:FIX THE QUESTIONS - 4 alternatives always
        for (int i = 0; i < mascots.size(); i++) {
            if (mascots.get(i).getName() == "kalleAnka") {
               // mascots.get(i).setQuestion(new Question(
                // "What is kalle ankas love interest called?",
                //  ["Kajsa", "Dorothy", "Jane"],
                //  0));
            }
            else if(mascots.get(i).getName() == "hackeHackspett") {
               // mascots.get(i).setQuestion(new Question(
                // "What is kalle ankas love interest called?",
                //  ["Kajsa", "Dorothy", "Jane"],
                // 0));
            }
            else if(mascots.get(i).getName() == "iTSmurfen") {
              //  mascots.get(i).setQuestion(new Question(
                // "What is kalle ankas love interest called?",
                // ["Kajsa", "Dorothy", "Jane"],
                // 0));
            }
            else if(mascots.get(i).getName() == "luckyluke") {
               // mascots.get(i).setQuestion(new Question(
                // "What is kalle ankas love interest called?",
                // ["Kajsa", "Dorothy", "Jane"],
                // 0));
            }
        }
    }
}
