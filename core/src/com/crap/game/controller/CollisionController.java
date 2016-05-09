package com.crap.game.controller;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.crap.game.model.CollisionModel;
import com.crap.game.view.GameView;

import java.util.Iterator;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionController {
    CollisionModel collisionModel;

    private TiledMap map;  //The whole map
    private MapLayers allLayers;
    private MapLayer collisionLayer;
    private MapObjects collisionObjects;

    private MapLayer slowLayer;
    private MapObjects slowObjects;

    private MapLayer newWorldLayer;
    private MapObjects newWorldObjects;

    public CollisionController() {
        collisionModel = new CollisionModel();
        this.map = GameView.map;
        allLayers = map.getLayers();
        collisionLayer = allLayers.get("Collision");
        collisionObjects = collisionLayer.getObjects();

        slowLayer = allLayers.get("SlowLayer");
        slowObjects = slowLayer.getObjects();

        newWorldLayer = allLayers.get("NewWorld");
        newWorldObjects = newWorldLayer.getObjects();
    }
    public boolean isSlowerTerrain(float x, float y){
        updateTileValues(x, y);
        return collisionModel.isSlow();
    }
    public boolean isCollison(float x, float y){
        updateCollisionValues(x,y);
        return collisionModel.isBlocked();
    }

    public void updateTileValues(float x, float y){
        if(isMapObjectHit(slowObjects.iterator(), x, y)) {
            collisionModel.setTypeOfTile(CollisionModel.tileType.SLOWER_TILE);
        }else{
            collisionModel.setTypeOfTile(CollisionModel.tileType.WALKABLE_TILE);
        }
        if(isMapObjectHit(newWorldObjects.iterator(), x, y)){
            System.out.println("NEW WORLD!");
        }
    }

    public void seeIfNewWorld(float x, float y){
        /*if(isMapObjectHit(newWorldObjects.iterator(), x, y)){
            collisionModel.setTypeOfTile(CollisionModel.tileType.SOLID_TILE);
        }*/
    }

    public boolean isMapObjectHit(Iterator iter, float x, float y){
        while(iter.hasNext()) {
            MapObject tempObj = (MapObject) iter.next();
            Float positionX = (Float) tempObj.getProperties().get("x");
            Float positionY = (Float) tempObj.getProperties().get("y");
            Float width = (Float) tempObj.getProperties().get("width");
            Float height = (Float) tempObj.getProperties().get("height");
            if((x>positionX && x<(positionX+width))
                    &&(y>positionY && y< (positionY +height)) ){
                return true;
            }
        }return false;
    }

    public void updateCollisionValues(float x, float y){
       if(isMapObjectHit(collisionObjects.iterator(), x, y)){
           collisionModel.setTypeOfTile(CollisionModel.tileType.SOLID_TILE);
       }
    }

}
