package com.crap.game.model;


import assets.maps.*;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionModel {


    private boolean isInCollision = false;
    private boolean blocked[][];

    //private String layer = "Collision";
    private int numOfTiles = 25;
    private MapLayer layer;
    private MapObjects collisionLayer = layer.getObjects();


    public boolean[][] getBlocked(){
        for(int i = 0; i < numOfTiles; i++){
            for(int j = 0;j < numOfTiles; j++ ){
                int tileID = getTileID(i, j, collisionLayer);
            }
        }
    }


}
