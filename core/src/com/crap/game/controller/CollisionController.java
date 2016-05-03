package com.crap.game.model;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.crap.game.view.WorldView;

import java.util.List;

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
        collisionObjects = collisionLayer.getObjects();  //The layer with the collision objects

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
        if(collisionModel.isSlow()){
            return true;
        }
        return false;
    }

    public void updateCollisionValues(int x, int y){
        TiledMapTileLayer.Cell cell = collisionLayer.getCell(x/32, y/32);
        if(cell.getTile().getProperties().containsKey("Collision")) {
            collisionModel.setTypeOfTile(CollisionModel.tileType.SOLID_TILE);
        }if(cell.getTile().getProperties().containsKey("Slower")){
            collisionModel.setTypeOfTile(CollisionModel.tileType.SLOWER_TILE);
        }else{
            collisionModel.setTypeOfTile(CollisionModel.tileType.WALKABLE_TILE);
        }
    }

}
