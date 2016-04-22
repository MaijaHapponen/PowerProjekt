package com.crap.game.model;



import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.List;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionModel {



    private boolean blocked[][];
    private List<TiledMapTileLayer.Cell> collisionCells;

    //private String layer = "Collision";
    private int numOfTiles = 25;
    private TiledMap map;  //The whole map
    private MapLayer collisionLayer = map.getLayers().get("Collision");  //The layer with the collision objects

    MapObjects collisionObjects = collisionLayer.getObjects(); //The objects on the collision layer




    public List<TiledMapTileLayer.Cell> getBlockedTiles(){
        for(int i = 0; i < numOfTiles; i++){ //tiles top to bottom
            for(int j = 0;j < numOfTiles; j++ ){ //tiles left to right
                TiledMapTileLayer.Cell cell = collisionLayer.getCell(i, j);
                if(cell.getTile().getProperties().containsKey("Collision")) {
                    blocked[i][j] = true;
                    collisionCells.add(cell);
                }else{
                    blocked[i][j] = false;
                }
            }
        } return collisionCells;
    }


}
