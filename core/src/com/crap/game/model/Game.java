package com.crap.game.model;

import java.util.ArrayList;

/**
 * Created by Lisa on 24/04/16.
 */
public class Game {

    public enum Worlds{HORSAL, EDIT, HUBBEN, ZALOONEN}

    private float startPositionX;
    private float startPositionY;
    private Progress progress;
    public Player player;
    private Questions questions;
    private Information information;
    private Worlds currectWorld;

    public static ArrayList<Human> humans = new ArrayList<Human>();
    public static ArrayList<Mascot> mascots = new ArrayList<Mascot>();

    private String[] mascotNames = {"iTSmurfen","kalleAnka","hackeHackspett","luckyLuke"};
    private float[][] mascotCoordinates = {{447, 461},{548, 688},{594, 92},{724, 592}};
    private Worlds[] mascotsWorlds = {Worlds.HUBBEN, Worlds.EDIT, Worlds.HORSAL, Worlds.ZALOONEN};

    private String[] humansNames = {"ITHuman","EHuman","DHuman","ZHuman"};
    private float[][] humanCoordinates = {{436, 503},{194, 87},{583, 51},{123, 98}};
    private Worlds[] humansWorlds = {Worlds.HORSAL, Worlds.EDIT, Worlds.HUBBEN, Worlds.HORSAL};

    public Game(){

        this.player = new Player("player",startPositionX,startPositionY);
        createHumans();
        createMascots();
        this.questions = new Questions(mascots);
        this.information = new Information(humans);

        this.progress = new Progress(mascots);
    }

    //Populates an arrayList with humans.
    public void createHumans(){
        for(int i=0; i<humansNames.length; i++){
            Position position = new Position(humanCoordinates[i][0],humanCoordinates[i][1]);
            humans.add(new Human(humansNames[i], position, humansWorlds[i]));
        }
    }

    //Populates an arrayList with mascots.
    public void createMascots(){
        for(int i=0; i<mascotNames.length; i++){
            Position position = new Position(mascotCoordinates[i][0],mascotCoordinates[i][1]);
            mascots.add(new Mascot(mascotNames[i], position, mascotsWorlds[i]));
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

    public void mascotCaught(Mascot caughtMascot){
        progress.mascotCaught(caughtMascot);
    }

    public Progress getProgress() {
        return progress;
    }

    public void setStartPositionPlayer(float x, float y) {
        this.startPositionX = x;
        this.startPositionY = y;
    }

    public void setCurrectWorld(Worlds currectWorld){
        this.currectWorld = currectWorld;
    }

    public Worlds getCurrectWorld(){
        return this.currectWorld;
    }
}
