package com.crap.game.model.character.mascotinteraction;

import com.crap.game.model.character.Character;
import com.crap.game.model.character.Mascot;

import java.util.List;

/**
 * Created by rebeccafinne on 16-05-20.
 */
public class InteractMascot {

    private String currentString;
    private int currentStringNbr;
    private List<String> stringsInScreen;

    private boolean hasAnswered;

    private boolean caughtMascot;

    public InteractMascot(List<String> stringsInScreen){
        this.stringsInScreen = stringsInScreen;
        this.currentStringNbr = 0;
        this.currentString = stringsInScreen.get(currentStringNbr);
    }

    public void setCurrentString(String direction){
        int amountOfStrings = getAmountOfStrings() - 1;

        if(direction.equals("nextStepDown")){
            if(currentStringNbr == amountOfStrings){
                currentStringNbr = 0;
            }
            else{
                currentStringNbr++ ;
            }
        }
        if(direction.equals("nextStepUp")){
            if(currentStringNbr == 0){
                currentStringNbr = amountOfStrings;
            }
            else {
                currentStringNbr--;
            }
        }
        currentString = stringsInScreen.get(currentStringNbr);
    }

    public String getCurrentString(){
        return this.currentString;
    }

    public int getAmountOfStrings(){
        return stringsInScreen.size();
    }

    public int getCurrentStringNbr(){
        return this.currentStringNbr;
    }

    public boolean isRightAnswer(Character character, int chosenString){
        if(character instanceof Mascot){
            if(chosenString == ((Mascot) character).getQuestion().getCorrectAnswer()){
                return true;
            }
        }
        return false;
    }


    public String getQuestion(Character interactionCharacter){

        if(interactionCharacter instanceof Mascot){
            return ((Mascot) interactionCharacter).getQuestion().getQuestion();
        }

        return null;
    }

    public java.util.List<String> getAnswers(Character interactionCharacter) {

        if (interactionCharacter instanceof Mascot) {
            return ((Mascot) interactionCharacter).getQuestion().getAlternatives();
        }

        return null;
    }

    public boolean isMascotCaught(){
        return this.caughtMascot;
    }

    public void updateMascotCaught(){
        this.caughtMascot = false;
    }

    public void setHasAnswered(){
        this.hasAnswered = true;
    }

    public boolean getHasAnswered(){
        return this.hasAnswered;
    }
}
