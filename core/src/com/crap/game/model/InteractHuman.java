package com.crap.game.model;

/**
 * Created by rebeccafinne on 16-05-23.
 */
public class InteractHuman {

    String [] options;
    String currentString;
    int currentStringNbr;

    private boolean isProgramme;
    private boolean isMascot;


    private String talkAboutProgramme = "Ask about programme";
    private String whereIsMascot = "Ask where mascot could be";

    private String back = "Press BACK SPACE to return to game";
    private String exit = "Exit";

    public InteractHuman(String[] options, String s){
        this.options = options;
        this.currentString = s;
        currentStringNbr = 0;
    }

    public void setCurrentString(String direction){
        int amoutOfStrings = options.length - 1;

        if(direction.equals("nextStepDown")){
            if(currentStringNbr == amoutOfStrings){
                currentStringNbr = 0;
            }else{
                currentStringNbr ++;
            }
        }if(direction.equals("nextStepUp")){
            if(currentStringNbr == 0){
                currentStringNbr = 3;
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


    public String getTalkAboutProgramme(){
        return this.talkAboutProgramme;
    }

    public String getWhereIsMascot(){
        return this.whereIsMascot;
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

    public String getBack(){
        return this.back;
    }

    public String getExit(){
        return this.exit;
    }

}
