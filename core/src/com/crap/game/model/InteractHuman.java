package com.crap.game.model;

/**
 * Created by rebeccafinne on 16-05-23.
 */
public class InteractHuman {

    String [] options;
    String currentString;
    int currentStringNbr;

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

}
