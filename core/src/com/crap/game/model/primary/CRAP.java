package com.crap.game.model.primary;

import com.crap.game.model.character.humaninteraction.Information;
import com.crap.game.model.character.mascotinteraction.InformationForQuestion;
import com.crap.game.model.character.Human;
import com.crap.game.model.character.Mascot;
import com.crap.game.model.character.Player;
import com.crap.game.model.information.enums.Worlds;

import java.util.ArrayList;

import static com.crap.game.model.information.Constants.*;

public class CRAP {


    private float startPositionX;
    private float startPositionY;
    private Progress progress;
    public Player player;
    private Information information;
    private Worlds currentWorld;

    private boolean newWorld;

    private boolean isEntrance;
    private Position entrancePosition;
    private Worlds previousRoom;

    public static ArrayList<Human> humans = new ArrayList<Human>();
    public static ArrayList<Mascot> mascots = new ArrayList<Mascot>();

    private String[] mascotNames = {"iTSmurfen","kalleAnka","hackeHackspett","luckyLuke"};
    private float[][] mascotCoordinates = {{447, 461},{548, 688},{594, 92},{724, 592}};
    private Worlds[] mascotsWorlds = {Worlds.HUBBEN, Worlds.EDIT, Worlds.HORSAL, Worlds.ZALOONEN};

    private String[] humansNames = {"ITHuman","EHuman","DHuman","ZHuman"};
    private float[][] humanCoordinates = {{436, 503},{194, 87},{583, 101},{123, 98}};
    private Worlds[] humansWorlds = {Worlds.HORSAL, Worlds.EDIT, Worlds.HUBBEN, Worlds.HORSAL};

    public CRAP(){

        this.player = new Player("player",startPositionX,startPositionY);
        createHumans();
        createMascots();
        InformationForQuestion questions = new InformationForQuestion(mascots);
        this.information = new Information(humans);

        this.progress = new Progress(mascots);

        this.isEntrance = false;
        this.entrancePosition = new Position(0,0);
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

    public void setCurrentWorld(Worlds currentWorld){
        this.currentWorld = currentWorld;
    }

    public Worlds getCurrentWorld(){
        return this.currentWorld;
    }

    public void enterHubben(){
        player.setPosition(HUBBEN_ENTRY_X, HUBBEN_ENTRY_Y);
    }

    public void enterZaloonen(){
        player.setPosition(ZALOON_ENTRY_X, ZALOON_ENTRY_Y);
    }

    public void setEntrance(float x, float y){
        this.entrancePosition.setPosition(x,y);
        this.isEntrance = true;
    }

    public Position getEntrancePosition(){
        return this.entrancePosition;
    }

    public Worlds getPreviousRoom(){
        return this.previousRoom;
    }

    public void setExit(){
        isEntrance = false;
    }

    public void setPreviousRoom(Worlds lastRoom) {
        this.previousRoom = lastRoom;
    }

    public void setNewWorld(boolean b){
        this.newWorld = b;
    }

    public boolean getNewWorld(){
        return this.newWorld;
    }
}
