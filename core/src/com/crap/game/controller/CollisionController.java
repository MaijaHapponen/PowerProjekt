package com.crap.game.controller;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.crap.game.model.CollisionModel;
import com.crap.game.view.GameView;
import com.crap.game.view.PlayerView;
import com.crap.game.view.WorldView;

import java.util.Iterator;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionController {

    private WorldView view;
    CollisionModel collisionModel;

    private TiledMap map;  //The whole map
    private MapLayers allLayers;
    private MapLayer collisionLayer;
    private MapObjects collisionObjects;

    private MapLayer slowLayer;
    private MapObjects slowObjects;

    private MapLayer newWorldLayer;
    private MapObjects newWorldObjects;

    private MapObject mapObject;

    private float playerWidth;
    private float playerHeight;

    public CollisionController(TiledMap view) {
        collisionModel = new CollisionModel();

        this.map = view;
        allLayers = map.getLayers();
        collisionLayer = allLayers.get("Collision");
        collisionObjects = collisionLayer.getObjects();

        slowLayer = allLayers.get("SlowLayer");
        slowObjects = slowLayer.getObjects();

        newWorldLayer = allLayers.get("NewWorld");
        newWorldObjects = newWorldLayer.getObjects();
    }

    public void setPlayerWidthAndHeight(float width, float height){
        this.playerWidth = width;
        this.playerHeight = height;
    }

    public boolean isSlowerTerrain(float x, float y){
        updateTileValues(x, y);
        return collisionModel.isSlow();
    }

    public boolean isCollison(float x, float y){
        updateCollisionValues(x,y);
        return collisionModel.isBlocked();
    }

    public boolean isNewWorld(float x, float y){
        updateTileValues(x,y);
        return collisionModel.isNewWorld();
    }

    public void updateTileValues(float x, float y){
        if(isMapObjectHit(slowObjects.iterator(), x, y)) {
            collisionModel.setTypeOfTile(CollisionModel.tileType.SLOWER_TILE);
        }
        else if(isMapObjectHit(newWorldObjects.iterator(), x, y)){
            collisionModel.setTypeOfTile(CollisionModel.tileType.NEW_WORLD);
        }
        else{
            collisionModel.setTypeOfTile(CollisionModel.tileType.WALKABLE_TILE);
        }
    }

    public boolean isMapObjectHit(Iterator iter, float x, float y){
        while(iter.hasNext()) {
            mapObject = (MapObject) iter.next();

            if( checkIfCollide(x,y)||checkIfCollide(x+playerWidth,y)||
                    checkIfCollide(x+playerWidth,y+playerHeight)||checkIfCollide(x,y+playerHeight)
                    ||checkIfCollide(x,y+playerHeight/2)||checkIfCollide(x+playerWidth,y+playerHeight/2)){
                return true;
            }
        }
        return false;
    }


    public boolean checkIfCollide(float playerPositionX, float playerPositionY) {

        Float x = (Float) mapObject.getProperties().get("x");
        Float y = (Float) mapObject.getProperties().get("y");
        Float width = (Float) mapObject.getProperties().get("width");
        Float height = (Float) mapObject.getProperties().get("height");

        return (playerPositionX > x && playerPositionX < x+width) && (playerPositionY>y && playerPositionY<y+height) ;
    }

    public void updateCollisionValues(float x, float y){
        if(isMapObjectHit(newWorldObjects.iterator(), x, y)){
            collisionModel.setTypeOfTile(CollisionModel.tileType.NEW_WORLD);
        }
       else if(isMapObjectHit(collisionObjects.iterator(), x, y)){
           collisionModel.setTypeOfTile(CollisionModel.tileType.SOLID_TILE);
       }
    }

}
