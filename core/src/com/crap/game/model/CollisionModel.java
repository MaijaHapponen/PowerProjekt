package com.crap.game.model;

import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.crap.game.view.WorldView;

import java.util.List;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionModel {

    public enum typeOfTile {WALKABLE_TILE, SOLID_TILE, SLOWER_TILE}; //The different types of tiles

    //private boolean[][] blocked;
    private TiledMap map;  //The whole map
    private MapLayers allLayers;
    private TiledMapTileLayer collisionLayer;
     // Player player = new Player();

    public CollisionModel(){
        this.map = WorldView.map;
        allLayers = map.getLayers();
        collisionLayer = (TiledMapTileLayer) allLayers.get(4);  //The layer with the collision objects

    }
    /* public CollisionModel(){
        blocked = new boolean[collisionLayer.getHeight()][collisionLayer.getWidth()];
    }*/


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


  /*  public void setBlockedTiles(){
        for(int i = 0; i < collisionLayer.getHeight(); i++){
            for(int j = 0;j < collisionLayer.getWidth(); j++ ){
                TiledMapTileLayer.Cell cell = collisionLayer.getCell(i, j);
                if(cell.getTile().getProperties().containsKey("Collision")) {
                    blocked[i][j] = true;
                }else{
                    blocked[i][j] = false;
                }
            }
        }
    }


    public boolean getBlockedTiles(int x, int y){
        if(blocked[x][y]){    //The player can't walk there, will be collision
            return true;
        }else{
            return false;   //No obstacle
        }
    }*/


}
