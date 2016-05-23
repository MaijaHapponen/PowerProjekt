package com.crap.game.model;

import java.util.ArrayList;

/**
 * Created by Lisa on 24/04/16.
 */
public class Game {

    public enum Worlds{HORSAL, EDIT, HUBBEN, ZALOONEN}

    private int startPositionX = 250;
    private int startPositionY = 250;
    private Progress progress;
    public Player player;
    private Questions questions;
    private Information information;

    public static ArrayList<Human> humans = new ArrayList<Human>();
    public static ArrayList<Mascot> mascots = new ArrayList<Mascot>();
    private String[] mascotNames = {"kalleAnka","hackeHackspett","ZHuman","luckyLuke"};
    private String[] humansNames = {"EHuman","DHuman","ITHuman","ZHuman"};

    public Game(){
        this.progress = new Progress();
        this.player = new Player(startPositionX,startPositionY);
        createHumans();
        createMascots();
        this.questions = new Questions(mascots);
        this.information = new Information(humans);
    }

    //Populates an arrayList with humans.
    public void createHumans(){
        for(int i=0; i<humansNames.length; i++){
            Position position = new Position(i*100+200, i*50+200); //TODO setn borde man nog ha en lista med karaktärernas positioner.
            humans.add(new Human(humansNames[i], position));
        }
    }

    //Populates an arrayList with mascots.
    public void createMascots(){
        for(int i=0; i<mascotNames.length; i++){
            Position position = new Position(i*50+200, i*100+200); //TODO sen borde man nog ha en lista med karaktärernas positioner.
            mascots.add(new Mascot(mascotNames[i], position));
        }
    }

    public ArrayList<Human> getHumans(){
        return this.humans;
    }

    public ArrayList<Mascot> getMascots(){
        return this.mascots;
    }

    //Checks if the game is over.
    public boolean isGameOver(){
        if(progress.areAllMascotsCaught()){
            return true;
        }
        return false;
    }

    public Progress getProgress() {
        return progress;
    }
}
