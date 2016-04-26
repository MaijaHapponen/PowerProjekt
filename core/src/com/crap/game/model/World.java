package com.crap.game.model;

import java.util.ArrayList;

/**
 * Created by Lisa on 24/04/16.
 */
public class World {

    private Progress progress;
    public static Player player;
    public static ArrayList<Human> humans = new ArrayList<Human>();
    //public static CollisionModel collision;
    //public static TiledMap map;
    //private String level;

    //Constructor
    public World(){
        this.progress = new Progress();
        this.player = new Player();
        //this.collision = new CollisionModel();

        for(int i=0; i<0; i++){
            Position position = new Position(i*40, i*40); //TODO sen borde man nog ha en lista med charactärernas positioner.
            humans.add(new Human(position)); //TODO och en lista med deras "utseenden"
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
