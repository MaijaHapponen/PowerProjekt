package com.crap.game.model;

import com.badlogic.gdx.Screen;
import com.crap.game.Main;

import java.util.ArrayList;

/**
 * Created by Lisa on 24/04/16.
 */
public class Game {

    public enum Worlds{HORSAL, EDIT, PARKING, HUBBEN, EDIT2, ZALOONEN}

    public Main main;

    private int startPositionX = 250;
    private int startPositionY = 250;
    private Progress progress;
    public Player player;
    private State state;

    public static ArrayList<Human> humans = new ArrayList<Human>();
    public static ArrayList<Mascot> mascots = new ArrayList<Mascot>();
    private String[] mascotNames = {"kalleAnka","hackeHackspett","iTSmurfen","luckyLuke"};
    private String[] humansNames = {"EHuman","DHuman","ITHuman","ZHuman"};
    private String[] worldNames = {"horsalmaskin", "hubbeneditsand", "parkingtemplate"};

    public Game(Main main){
        this.main = main;
        this.progress = new Progress();
        this.player = new Player(startPositionX,startPositionY);
        createHumans();
        createMascots();

        this.state = new State(this);
    }

    //Populates an arrayList with humans.
    public void createHumans(){
        for(int i=0; i<humansNames.length; i++){
            Position position = new Position(i*100, i*50); //TODO setn borde man nog ha en lista med karaktärernas positioner.
            humans.add(new Human(humansNames[i], position));
        }
    }

    //Populates an arrayList with mascots.
    public void createMascots(){
        for(int i=0; i<mascotNames.length; i++){
            Position position = new Position(i*50, i*100); //TODO sen borde man nog ha en lista med karaktärernas positioner.
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

    public Player getPlayer(){
        return player;
    }

    public String[] getWorldNames(){ return this.worldNames;}

    public Progress getProgress() {
        return progress;
    }

    public void setScreen(Screen screen){
        main.setScreen(screen);
    }

    public void startMainMenu(){
        State.updateState(State.GameStates.STARTMENU);
    }

    public void initPlay(){
        main.initPlay();
    }
    public void unPauseGame(){
        main.playMode();
    }

}
