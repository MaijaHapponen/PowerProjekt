package com.crap.game.controller;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.crap.game.model.CollisionModel;
import com.crap.game.view.WorldView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionController {
    CollisionModel collisionModel;

    private TiledMap map;  //The whole map
    private MapLayers allLayers;
    private MapLayer collisionLayer;
    private MapObjects collisionObjects;

    public CollisionController(){
        collisionModel = new CollisionModel();
        this.map = WorldView.map;
        allLayers = map.getLayers();
        collisionLayer = allLayers.get("Collision");
        collisionObjects = collisionLayer.getObjects();//The layer with the collision objects

    }

    //TODO: Cannot take in a position, trying dividing it in tile size
    //Takes a position and check what type of tile it is.
    public boolean isCollision(int x, int y){
        updateCollisionValues(x,y);
        if(collisionModel.isBlocked()){
            return true;
        }
        return false;
    }

    public boolean isSlowerTerrain(){
        if(collisionModel.isSlow()) {
            return true;
        }
        return false;
    }
    public void updateCollisionValues(int x, int y){
        Iterator iter = collisionObjects.iterator();
        if(iter.hasNext()){
            MapObject tempObj = (MapObject) iter.next();
            Float positionX = (Float) tempObj.getProperties().get("x");
            Float positionY = (Float) tempObj.getProperties().get("y");
            Float width = (Float) tempObj.getProperties().get("width");
            Float height = (Float) tempObj.getProperties().get("height");

           if(x>positionX.intValue() || x<(positionX.intValue()+width.intValue())
                  ||y<positionY.intValue() || y> (positionY.intValue()-height.intValue()) ){
               collisionModel.setTypeOfTile(CollisionModel.tileType.SOLID_TILE);
               System.out.println("DAFUQ");
           }else {
                collisionModel.setTypeOfTile(CollisionModel.tileType.WALKABLE_TILE);
            }
        }
    }
}
