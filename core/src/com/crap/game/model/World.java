package com.crap.game.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by Lisa on 24/04/16.
 */
public class World {

    private Progress progress;
    public static Player player;
    //public static CollisionModel collision;
    //public static TiledMap map;
    //private String level;

    //Constructor
    public World(){
        this.progress = new Progress();
        this.player = new Player();
        //this.collision = new CollisionModel();
    }

    //Checks if the game is over.
    public boolean isGameOver(){
        if(progress.areAllMascotsCaught()){
            return true;
        }
        return false;
    }
}
