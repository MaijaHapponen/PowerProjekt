package com.crap.game.model.character.humaninteraction;

/**
 * Created by rebeccafinne on 16-05-23.
 */
public class InteractHuman {

    String [] options;
    String currentString;
    int currentStringNbr;

    private boolean isProgramme;
    private boolean isMascot;

    public InteractHuman(String[] options, String s){
        this.options = options;
        this.currentString = s;
        currentStringNbr = 0;
    }

    public void setCurrentString(String direction){
        int amoutOfStrings = options.length - 1;

        if(direction.equals("down")){
            if(currentStringNbr == amoutOfStrings){
                currentStringNbr = 0;
            }else{
                currentStringNbr ++;
            }
        }if(direction.equals("up")){
            if(currentStringNbr == 0){
                currentStringNbr = amoutOfStrings;
            }else{
                currentStringNbr --;
            }
        }
        currentString = options[currentStringNbr];
    }

    public String getCurrentString(){
        return this.currentString;
    }
    public int getCurrentStringNbr(){
        return this.currentStringNbr;
    }

    public void setIsMascot(boolean b){
        this.isMascot = b;
    }

    public boolean getIsMascot(){
        return this.isMascot;
    }

    public void setIsProgramme(boolean b){
        this.isProgramme = b;
    }

    public boolean getIsProgramme(){
        return this.isProgramme;
    }

}
