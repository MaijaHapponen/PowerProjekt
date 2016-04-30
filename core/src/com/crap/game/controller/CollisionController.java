package com.crap.game.controller;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

/**
 * Created by rebeccafinne on 2016-04-30.
 */
public class CollisionController {

    public enum typeOfTile {WALKABLE_TILE, SOLID_TILE, SLOWER_TILE}; //The different types of tiles

    //private boolean[][] blocked;
    private TiledMap map;  //The whole map
    private TiledMapTileLayer collisionLayer;
    // Player player = new Player();


    public CollisionController(){

    }

    //Takes a position and check what tyoe of tile it is.
    public typeOfTile getTypeOfTile(int x, int y){
        TiledMapTileLayer.Cell cell = collisionLayer.getCell(x, y);
        if(cell.getTile().getProperties().containsKey("Collision")){
            return typeOfTile.SOLID_TILE;
        }if(cell.getTile().getProperties().containsKey("Slower")){
            return typeOfTile.SLOWER_TILE;
        }else{
            return typeOfTile.WALKABLE_TILE;
        }
    }

}
