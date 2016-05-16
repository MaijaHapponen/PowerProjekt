package com.crap.game.model;

import java.util.ArrayList;

/**
 * Created by Lisa on 24/04/16.
 */
public class Game {

    public enum Worlds{HORSAL, EDIT, PARKING, HUBBEN}

    private Progress progress;
    public Player player;
    public static ArrayList<Human> humans = new ArrayList<Human>();
    public static ArrayList<Mascot> mascots = new ArrayList<Mascot>();
    private String[] mascotNames = {"donald"};//{"kalleAnka","hackeHackspett","iTSmurfen","luckyLuke"};
    private String[] humansNames = {};//]{"EHuman","DHuman","ITHuman","ZHuman"};
    private String[] worldNames = {"horsalmaskin", "hubbeneditsand", "parkingtemplate"};

    public Game(){
        this.progress = new Progress();
        this.player = new Player();
        createHumans();
        createMascots();
    }

    //Populates an arrayList with humans.
    public void createHumans(){
        for(int i=0; i<humansNames.length; i++){
            Position position = new Position(i*50, i); //TODO setn borde man nog ha en lista med karaktärernas positioner.
            humans.add(new Human(humansNames[i], position));
        }
    }

    //Populates an arrayList with mascots.
    public void createMascots(){
        for(int i=0; i<mascotNames.length; i++){
            Position position = new Position(300, 300); //TODO sen borde man nog ha en lista med karaktärernas positioner.
            mascots.add(new Mascot(mascotNames[i], position));
        }
    }

    //Checks if the game is over.
    public boolean isGameOver(){
        if(progress.areAllMascotsCaught()){
            return true;
        }
        return false;
    }

    public Player getPlayer(){
        return player;
    }

    public String[] getWorldNames(){ return this.worldNames;}

    public Progress getProgress() {
        return progress;
    }
}
