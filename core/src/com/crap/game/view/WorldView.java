package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 * Created by andrea on 2016-05-09.
 */
public class WorldView extends ApplicationAdapter implements Screen {

    private TiledMap world;
    public static SpriteBatch batch;
    private String level;

    public WorldView(){
        this.level = "horsalmaskin";
        this.world = new TmxMapLoader().load("maps/"+level+".tmx");

        world = new TmxMapLoader().load("maps/"+level+".tmx");
    }

    public void setWorld(TiledMap world){
        this.world = world;
    }

    public TiledMap getWorld(){
        return this.world;
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void hide() {

    }
}
