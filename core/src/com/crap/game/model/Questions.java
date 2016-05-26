package com.crap.game.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andrea on 2016-05-23.
 */
public class Questions {

    public Questions(ArrayList<Mascot> mascots){
        setQuestions(mascots);
    }

    public void setQuestions(ArrayList<Mascot> mascots) {

        for (int i = 0; i < mascots.size(); i++) {

            if (mascots.get(i).getName().equals("kalleAnka")) {

                String kalleAnkaQuestion = "What is kalle ankas love \n interest called?";
                List<String> kalleAnkaAlternatives = Arrays.asList("Kajsa", "Dorothy", "Mimmi", "Monica");
                int kalleAnkaRightAnswer = 0;

                mascots.get(i).setQuestion(
                        new Question(kalleAnkaQuestion, kalleAnkaAlternatives, kalleAnkaRightAnswer));
            }

            else if(mascots.get(i).getName().equals("hackeHackspett")) {

                String hackeHackspettQuestion = "What is Hacke Hackspetts \n favorite color?";
                List<String> hackeHackspettAlternatives = Arrays.asList("Red", "White", "Orange", "Green");
                int hackeHackspettRightAnswer = 2;

                mascots.get(i).setQuestion(
                        new Question(hackeHackspettQuestion, hackeHackspettAlternatives, hackeHackspettRightAnswer));
            }

            else if(mascots.get(i).getName().equals("iTSmurfen")) {

                String iTSmurfenQuestion = "What does the shortening \n 'IT' stand for?";
                List<String> iTSmurfenAlternatives =
                        Arrays.asList("InternetTechnology", "Informationsteknik", "IterationTest", "IThink");
                int iTSmurfenRightAnswer = 1;

                mascots.get(i).setQuestion(
                        new Question(iTSmurfenQuestion, iTSmurfenAlternatives, iTSmurfenRightAnswer));
            }

            else if(mascots.get(i).getName().equals("luckyLuke")) {

                String luckyLukeQuestion = "What is Lucky Lukes \n horse called?";
                List<String> luckyLukeAlternatives =
                        Arrays.asList("Holly Hunter", "Betty Bowler", "Randy Runner", "Jolly Jumper");
                int luckyLukeRightAnswer = 3;

                mascots.get(i).setQuestion(
                        new Question(luckyLukeQuestion, luckyLukeAlternatives, luckyLukeRightAnswer));
            }
        }
    }
}
