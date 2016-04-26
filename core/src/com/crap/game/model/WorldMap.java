package com.crap.game.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by andrea on 2016-04-26.
 */
public class WorldMap extends TiledMap{

    private String level;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    public WorldMap() {
        this.level = "hubbeneditsand";
        map = new TmxMapLoader().load("maps/" + level + ".tmx");
    }

    public TiledMap getMap(){
        return map;
    }
}
