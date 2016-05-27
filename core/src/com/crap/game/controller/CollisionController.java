package com.crap.game.controller;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.crap.game.model.*;
import com.crap.game.model.Character;

import java.util.Iterator;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionController {

    CollisionModel collisionModel;

    private MapLayers allLayers;
    private MapLayer collisionLayer;
    private MapObjects collisionObjects;

    private MapLayer slowLayer;
    private MapObjects slowObjects;

    private MapLayer newWorldLayer;
    private MapObjects newWorldObjects;
    private MapObject newWorldObject;
    private String newWorldName;

    private int characterWidth;
    private int characterHeight;

    public CollisionController(TiledMap map) {
        collisionModel = new CollisionModel();
        allLayers = map.getLayers();
        collisionLayer = allLayers.get("Collision");
        collisionObjects = collisionLayer.getObjects();

        slowLayer = allLayers.get("SlowLayer");
        slowObjects = slowLayer.getObjects();

        newWorldLayer = allLayers.get("NewWorld");
        newWorldObjects = newWorldLayer.getObjects();
    }

    public void setPlayerWidthAndHeight(int width, int height){
        characterWidth = width;
        characterHeight = height;
    }

    public boolean isSlowerTerrain(){
        return collisionModel.isSlow();
    }

    public boolean isCollison(Character thisCharacter, float x, float y){
        updateTileValues(thisCharacter,x, y);
        return collisionModel.isBlocked();
    }

    public boolean isNewWorld(float x, float y){
        return collisionModel.isNewWorld();
    }

    public void updateTileValues(Character thisCharacter, float x, float y){
        if(isMapObjectHit(collisionObjects.iterator(),thisCharacter, x, y)){
            collisionModel.setTypeOfTile(TileType.SOLID_TILE);
        }
        else if(isMapObjectHit(slowObjects.iterator(),thisCharacter, x, y)) {
            collisionModel.setTypeOfTile(TileType.SLOWER_TILE);
        }
        else{
            collisionModel.setTypeOfTile(TileType.WALKABLE_TILE);
        }

        if(isMapObjectHit(newWorldObjects.iterator(),thisCharacter, x, y)) {
            collisionModel.setTypeOfTile(TileType.NEW_WORLD);
            newWorldName = newWorldObject.getName();
        }
    }

    public boolean isMapObjectHit(Iterator iter, Character thisCharacter){
        while(iter.hasNext()) {
            MapObject mapObject = (MapObject) iter.next();
            Float posX = (Float) mapObject.getProperties().get("x");
            Float posY = (Float) mapObject.getProperties().get("y");
            Float width = (Float) mapObject.getProperties().get("width");
            Float height = (Float) mapObject.getProperties().get("height");

            float characterX = thisCharacter.getX();
            float characterY = thisCharacter.getY();
            float characterWidth

            if( checkIfCollide(posX, posY, width, height, thisCharacter.getX(), thisCharacter.getY()) ||
                    checkIfCollide(posX, posY, width, height, thisCharacter.getX() + thisCharacter.getWidth(), thisCharacter.getY()) ||
                    checkIfCollide(posX, characterX + otherCharacterWidth, characterY + otherCharacterHeight) ||
                    checkIfCollide(posX, characterX, characterY + otherCharacterHeight) ||
                    //nextStepLeft side of character
                    checkIfCollide(posX, characterX, characterY + 3 * (otherCharacterHeight / 4)) ||
                    checkIfCollide(posX, characterX, characterY + otherCharacterHeight / 2) ||
                    checkIfCollide(posX, characterX, characterY + otherCharacterHeight / 4) ||
                    //nextStepRight side of character
                    checkIfCollide(posX, characterX + otherCharacterWidth, characterY + 3 * (otherCharacterHeight / 4)) ||
                    checkIfCollide(posX, characterX + otherCharacterWidth, characterY + otherCharacterHeight / 2) ||
                    checkIfCollide(posX, characterX + otherCharacterWidth, characterY + otherCharacterHeight / 4) ||
                    //middle in top and bottom of character
                    checkIfCollide(posX, characterX + otherCharacterWidth / 2, characterY) ||
                    checkIfCollide(posX, characterX + otherCharacterWidth / 2, characterY + otherCharacterHeight); ){
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

    //TODO: Move to model
    public String getNewWorldName(){
        return this.newWorldName;
    }

    public MapObject getNewWorldObject(){
        return this.newWorldObject;
    }
}
