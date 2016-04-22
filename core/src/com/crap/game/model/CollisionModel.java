package com.crap.game.model;



import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.crap.game.model.Player;

import java.util.List;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionModel {


    private boolean[][] blocked;
    private TiledMap map;  //The whole map
    private TiledMapTileLayer collisionLayer = (TiledMapTileLayer) map.getLayers().get("Collision");  //The layer with the collision objects

    public CollisionModel(){
        blocked = new boolean[collisionLayer.getHeight()][collisionLayer.getWidth()];
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

    public boolean isCollision(int x, int y){
        if(blocked[x][y]){    //The player can't walk there, will be collision
            return true;
        }else{
            return false;   //No obstacle
        }
    }


}
