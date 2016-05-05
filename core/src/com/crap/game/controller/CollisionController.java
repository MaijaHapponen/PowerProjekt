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

    public CollisionController() {
        collisionModel = new CollisionModel();
        this.map = WorldView.map;
        allLayers = map.getLayers();
        collisionLayer = allLayers.get("Collision");
        collisionObjects = collisionLayer.getObjects();//The layer with the collision objects

    }
    public boolean isSlowerTerrain(){
        if(collisionModel.isSlow()) {
            return true;
        }
        return false;
    }
    public boolean isCollison(){
        if(collisionModel.isBlocked()) {
            return true;
        }
        return false;
    }

    public void updateCollisionValues(float x, float y){

        Iterator iter = collisionObjects.iterator();
        while(iter.hasNext()){
            MapObject tempObj = (MapObject) iter.next();
            Float positionX = (Float) tempObj.getProperties().get("x");
            Float positionY = (Float) tempObj.getProperties().get("y");
            Float width = (Float) tempObj.getProperties().get("width");
            Float height = (Float) tempObj.getProperties().get("height");

           if((x>positionX && x<(positionX+width))
                  &&(y>positionY && y< (positionY +height)) ){
               collisionModel.setTypeOfTile(CollisionModel.tileType.SOLID_TILE);
               break;
           }else {
                collisionModel.setTypeOfTile(CollisionModel.tileType.WALKABLE_TILE);
           }
        }
    }
}
