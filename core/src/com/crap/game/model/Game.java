package com.crap.game.model;

import com.badlogic.gdx.Screen;
import com.crap.game.Main;
import com.crap.game.controller.MenuController;
import com.crap.game.view.MenuView;

import java.util.ArrayList;

/**
 * Created by Lisa on 24/04/16.
 */
public class Game {

    public enum Worlds{HORSAL, EDIT, PARKING, HUBBEN}

    public Main main;
    public State state;
    private Progress progress;
    public Player player;
    public static ArrayList<Human> humans = new ArrayList<Human>();
    public static ArrayList<Mascot> mascots = new ArrayList<Mascot>();
    private String[] mascotNames = {"kalleAnka","hackeHackspett","iTSmurfen","luckyLuke"};
    private String[] humansNames = {"EHuman","DHuman","ITHuman","ZHuman"};
    private String[] worldNames = {"horsalmaskin", "hubbeneditsand", "parkingtemplate"};

    public Game(Main main){
        this.main = main;
        this.progress = new Progress();
        this.player = new Player(200,200);
        createHumans();
        createMascots();

        this.state = new State(this, State.GameStates.STARTMENU);
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

    public void initPlay(){
        main.initPlay();
    }
}
