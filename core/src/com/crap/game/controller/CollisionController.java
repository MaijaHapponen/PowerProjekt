package com.crap.game.controller;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.crap.game.model.*;
import java.util.Iterator;

public class CollisionController {

    CollisionModel collisionModel;
    private MapObjects collisionObjects;
    private MapObjects slowObjects;
    private MapObjects newWorldObjects;
    private MapObject newWorldObject;
    private String newWorldName;
    private float characterWidth;
    private float halfCharacterHeight;

    public CollisionController(TiledMap map) {
        collisionModel = new CollisionModel();
        MapLayers allLayers = map.getLayers();
        MapLayer collisionLayer = allLayers.get("Collision");
        collisionObjects = collisionLayer.getObjects();

        MapLayer slowLayer = allLayers.get("SlowLayer");
        slowObjects = slowLayer.getObjects();

        MapLayer newWorldLayer = allLayers.get("NewWorld");
        newWorldObjects = newWorldLayer.getObjects();
    }

    public void setCharacterWidthAndHeight(float width, float height){
        characterWidth = width;
        halfCharacterHeight = height/2;
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
        if(isMapObjectHit(collisionObjects.iterator(), x, y)){
            collisionModel.setTypeOfTile(TileType.SOLID_TILE);
        }
        else if(isMapObjectHit(slowObjects.iterator(), x, y)) {
            collisionModel.setTypeOfTile(TileType.SLOWER_TILE);
        }
        else{
            collisionModel.setTypeOfTile(TileType.WALKABLE_TILE);
        }

        if(isMapObjectHit(newWorldObjects.iterator(), x, y)) {
            collisionModel.setTypeOfTile(TileType.NEW_WORLD);
            newWorldName = newWorldObject.getName();
        }
    }

    public boolean isMapObjectHit(Iterator iter, float characterX, float characterY){
        while(iter.hasNext()) {
            MapObject mapObject = (MapObject) iter.next();
            Float posX = (Float) mapObject.getProperties().get("x");
            Float posY = (Float) mapObject.getProperties().get("y");
            Float width = (Float) mapObject.getProperties().get("width");
            Float height = (Float) mapObject.getProperties().get("height");

            if( checkIfCollide(posX,posY,width,height,characterX,characterY) ||
                    checkIfCollide(posX,posY,width,height, characterX + characterWidth, characterY) ||
                    checkIfCollide(posX,posY,width,height, characterX + characterWidth, characterY + halfCharacterHeight) ||
                    checkIfCollide(posX,posY,width,height, characterX, characterY + halfCharacterHeight) ||
                    //left side of character
                    checkIfCollide(posX,posY,width,height, characterX, characterY + 3*(halfCharacterHeight / 4)) ||
                    checkIfCollide(posX,posY,width,height, characterX, characterY + halfCharacterHeight / 2) ||
                    checkIfCollide(posX,posY,width,height, characterX, characterY + halfCharacterHeight / 4) ||
                    //right side of character
                    checkIfCollide(posX,posY,width,height, characterX + characterWidth, characterY + 3*(halfCharacterHeight / 4)) ||
                    checkIfCollide(posX,posY,width,height, characterX + characterWidth, characterY + halfCharacterHeight / 2) ||
                    checkIfCollide(posX,posY,width,height, characterX + characterWidth, characterY + halfCharacterHeight / 4) ||
                    //bottom of character
                    checkIfCollide(posX,posY,width,height, characterX + characterWidth / 4, characterY) ||
                    checkIfCollide(posX,posY,width,height, characterX + characterWidth / 2, characterY) ||
                    checkIfCollide(posX,posY,width,height, characterX + 3*(characterWidth / 4), characterY) ||
                    //top of character
                    checkIfCollide(posX,posY,width,height, characterX + characterWidth / 4, characterY + halfCharacterHeight)||
                    checkIfCollide(posX,posY,width,height, characterX + characterWidth / 2, characterY + halfCharacterHeight)||
                    checkIfCollide(posX,posY,width,height, characterX + 3*(characterWidth / 4), characterY + halfCharacterHeight)){
                newWorldObject = mapObject;
                return true;
            }
        }
        return false;
    }

    public boolean checkIfCollide(float objectX, float objectY, float objectWidth, float objectHeight,
                                  float characterPositionX, float characterPositionY) {
        return collisionModel.checkIfCollide(objectX,objectY,objectWidth,objectHeight,characterPositionX,characterPositionY);
    }

    public String getNewWorldName(){
        return this.newWorldName;
    }

    public MapObject getNewWorldObject(){
        return this.newWorldObject;
    }
}
