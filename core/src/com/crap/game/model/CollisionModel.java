package com.crap.game.model;



import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.crap.game.model.Player;

import java.util.List;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionModel {

    private enum typeOfTile {WALKABLE_TILE, SOLID_TILE, SLOWER_TILE};
    private boolean[][] blocked;
    private TiledMap map;  //The whole map
    private TiledMapTileLayer collisionLayer = (TiledMapTileLayer) map.getLayers().get("Collision");  //The layer with the collision objects
    Player player = new Player();


    public CollisionModel(){
        blocked = new boolean[collisionLayer.getHeight()][collisionLayer.getWidth()];
    }

    public typeOfTile getTypeOfTile(){
        TiledMapTileLayer.Cell cell = collisionLayer.getCell((int)player.getX(), (int)player.getY());
        if(cell.getTile().getProperties().containsKey("Collision")){
            return typeOfTile.SOLID_TILE;
        }if(cell.getTile().getProperties().containsKey("Slower")){
            return typeOfTile.SLOWER_TILE;
        }else{
            return typeOfTile.WALKABLE_TILE;
        }
    }


    public void setBlockedTiles(){
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
    }


}
