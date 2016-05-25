package com.crap.game.model;

/**
 * Created by rebeccafinne on 16-05-20.
 */
public class InteractMascot {

    private String currentString;
    private int currentStringNbr;
    private String[] stringsInScreen;

    private boolean caughtMascot;

    public InteractMascot(String[] stringsInScreen){
        this.stringsInScreen = stringsInScreen;
        this.currentStringNbr = 0;
        this.currentString = stringsInScreen[currentStringNbr];
    }

    public void setCurrentString(String direction){
        int amountOfStrings = getAmountOfStrings() - 1;

        if(direction.equals("down")){
            if(currentStringNbr == amountOfStrings){
                currentStringNbr = 0;
            }
            else{
                currentStringNbr++ ;
            }
        }
        if(direction.equals("up")){
            if(currentStringNbr == 0){
                currentStringNbr = 3;
            }
            else {
                currentStringNbr--;
            }
        }
        currentString = stringsInScreen[currentStringNbr];
    }

    public String getCurrentString(){
        return this.currentString;
    }

    public int getAmountOfStrings(){
        return stringsInScreen.length;
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

    public boolean isMascotCaught(){
        return this.caughtMascot;
    }

    public void updateMascotCaught(){
        this.caughtMascot = false;
    }
}
