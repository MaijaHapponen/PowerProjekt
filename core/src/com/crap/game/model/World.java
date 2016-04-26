package com.crap.game.model;

import java.util.ArrayList;

/**
 * Created by Lisa on 24/04/16.
 */
public class World {

    private Progress progress;
    public static Player player;
    public static ArrayList<Human> humans = new ArrayList<Human>();
    public static ArrayList<Mascot> mascots = new ArrayList<Mascot>();
    //public static CollisionModel collision;
    //public static TiledMap map;
    //private String level;

    //Constructor
    public World(){
        this.progress = new Progress();
        this.player = new Player();
        //this.collision = new CollisionModel();

        createHumans();
        createMascots();
    }

    //Populates an arrayList with humans.
    public void createHumans(){
        for(int i=0; i<0; i++){
            Position position = new Position(i*50, i); //TODO sen borde man nog ha en lista med karaktärernas positioner.
            humans.add(new Human(position)); //TODO och en lista med deras "utseenden"
        }
    }

    //Populates an arrayList with mascots.
    public void createMascots(){
        for(int i=0; i<0; i++){
            Position position = new Position(i, i*40); //TODO sen borde man nog ha en lista med karaktärernas positioner.
            mascots.add(new Mascot(position)); //TODO och en lista med deras "utseenden"
        }
    }

    //Checks if the game is over.
    public boolean isGameOver(){
        if(progress.areAllMascotsCaught()){
            return true;
        }
        return false;
    }
}
