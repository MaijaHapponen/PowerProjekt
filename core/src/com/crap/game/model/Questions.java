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

        for (int i = 0; i < mascots.size(); i++) {

            if (mascots.get(i).getName() == "kalleAnka") {

                String kalleAnkaQuestion = "What is kalle ankas love interest called?";
                String[] kalleAnkaAlternatives = new String [] {"Kajsa", "Dorothy", "Mimmi", "Monica"};
                int kalleAnkaRightAnswer = 0;

                mascots.get(i).setQuestion(
                        new Question(kalleAnkaQuestion, kalleAnkaAlternatives, kalleAnkaRightAnswer));
            }

            else if(mascots.get(i).getName() == "hackeHackspett") {

                String hackeHackspettQuestion = "What is Hacke Hackspetts favorite color?";
                String[] hackeHackspettAlternatives = new String [] {"Red", "White", "Orange", "Green"};
                int hackeHackspettRightAnswer = 2;

                mascots.get(i).setQuestion(
                        new Question(hackeHackspettQuestion, hackeHackspettAlternatives, hackeHackspettRightAnswer));
            }

            else if(mascots.get(i).getName() == "iTSmurfen") {

                String iTSmurfenQuestion = "What does the shortening 'IT' stand for?";
                String[] iTSmurfenAlternatives =
                        new String [] {"InternetTechnology", "Informationsteknik", "IterationTest", "IThink"};
                int iTSmurfenRightAnswer = 1;

                mascots.get(i).setQuestion(
                        new Question(iTSmurfenQuestion, iTSmurfenAlternatives, iTSmurfenRightAnswer));
            }

            else if(mascots.get(i).getName() == "luckyluke") {

                String luckyLukeQuestion = "What is Lucky Lukes horse called?";
                String[] luckyLukeAlternatives =
                        new String [] {"Holly Hunter", "Betty Bowler", "Randy Runner", "Jolly Jumper"};
                int luckyLukeRightAnswer = 3;

                mascots.get(i).setQuestion(
                        new Question(luckyLukeQuestion, luckyLukeAlternatives, luckyLukeRightAnswer));
            }
        }
    }
}
