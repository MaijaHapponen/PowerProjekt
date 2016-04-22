package com.crap.game.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import java.io.File;

/**
 * Created by andrea on 2016-04-22.
 */
public class MapReader{

    private TiledMap map;
    OrthogonalTiledMapRenderer renderer;

    public MapReader(File inputFile) {
        map = new TmxMapLoader().load("maps/"+inputFile);
    }
}
