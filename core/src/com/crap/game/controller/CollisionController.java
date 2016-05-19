package com.crap.game.controller;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.crap.game.model.CollisionModel;

import java.util.Iterator;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionController {

    CollisionModel collisionModel;

    private TiledMap map;
    private MapLayers allLayers;
    private MapLayer collisionLayer;
    private MapObjects collisionObjects;

    private MapLayer slowLayer;
    private MapObjects slowObjects;

    private MapLayer newWorldLayer;
    private MapObjects newWorldObjects;
    private MapObject newWorldObject;
    private String newWorldName;


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
        return collisionModel.isSlow();
    }

    public boolean isCollison(float x, float y){
        updateTileValues(x, y);
        return collisionModel.isBlocked();
    }

    public boolean isNewWorld(float x, float y){
        return collisionModel.isNewWorld();
    }

    public void updateTileValues(float x, float y){
        if(isMapObjectHit(slowObjects.iterator(), x, y)) {
            collisionModel.setTypeOfTile(CollisionModel.tileType.SLOWER_TILE);
        }
        else if(isMapObjectHit(newWorldObjects.iterator(), x, y)){
            collisionModel.setTypeOfTile(CollisionModel.tileType.NEW_WORLD);
            newWorldName = newWorldObject.getName();


        }
        else if(isMapObjectHit(collisionObjects.iterator(), x, y)){
            collisionModel.setTypeOfTile(CollisionModel.tileType.SOLID_TILE);
        }
        else{
            collisionModel.setTypeOfTile(CollisionModel.tileType.WALKABLE_TILE);
        }
    }


    public boolean isMapObjectHit(Iterator iter, float x, float y){
        while(iter.hasNext()) {
            MapObject mapObject = (MapObject) iter.next();
            Float posX = (Float) mapObject.getProperties().get("x");
            Float posY = (Float) mapObject.getProperties().get("y");
            Float width = (Float) mapObject.getProperties().get("width");
            Float height = (Float) mapObject.getProperties().get("height");

            if( checkIfCollide(posX,posY,width,height,x,y)||
                    checkIfCollide(posX,posY,width,height,x+playerWidth,y)||
                    checkIfCollide(posX,posY,width,height,x+playerWidth,y+playerHeight)||
                    checkIfCollide(posX,posY,width,height,x,y+playerHeight) ||
                    checkIfCollide(posX,posY,width,height,x,y+playerHeight/2)||
                    checkIfCollide(posX,posY,width,height,x+playerWidth,y+playerHeight/2)){
                newWorldObject = mapObject;
                return true;
            }
        }
        return false;
    }

    public boolean checkIfCollide(float x, float y, float width, float height, float playerPositionX, float playerPositionY) {
        return collisionModel.checkIfCollide(x,y,width,height,playerPositionX,playerPositionY);
    }


    public void setNewWorldName(String name){
        this.newWorldName = name;
    }

    public String getNewWorldName(){
        System.out.println(newWorldName);
        return this.newWorldName;

    }

    public MapObjects getNewWorldObjects() {
        return this.newWorldObjects;
    }

    public MapObject getNewWorldObject(){
        return this.newWorldObject;
    }

}
