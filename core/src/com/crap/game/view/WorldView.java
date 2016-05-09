package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.crap.game.model.*;
import com.badlogic.gdx.math.Intersector;

import java.util.ArrayList;

/**
 * Created by andrea on 2016-05-09.
 */
public class WorldView extends ApplicationAdapter implements Screen {

    private TiledMap world;

    private OrthographicCamera camera;
    private Sprite sprite;

    private PlayerView playerView;
    private ProgressView progressView;

    private ArrayList<CharacterView> humansList = new ArrayList<CharacterView>();
    private ArrayList<CharacterView> mascotsList = new ArrayList<CharacterView>();


    public WorldView(){
        this.level = "horsalmaskin";
        this.world = new TmxMapLoader().load("maps/"+level+".tmx");

        world = new TmxMapLoader().load("maps/"+level+".tmx");
    }

    public void setWorld(TiledMap world){
        this.world = world;
        this.playerView = new PlayerView();
        this.progressView = new ProgressView();

        map = new TmxMapLoader().load("maps/"+level+".tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        this.camera = playerView.getCamera();

        progressView.getVector2Length();
        
        if(distanceSegmentPoint(progressView.getVector2(), progressView.getPosition(), 250) == 0){

        }

        batch.setProjectionMatrix(camera.combined);

        renderer.setView(camera);
        renderer.render();

        batch.begin();
        
        for(int i = 0; i<humansList.size(); i++){
            humansList.get(i).getSprite().draw(batch);
        }
        for(int i = 0; i<mascotsList.size(); i++){
            mascotsList.get(i).getSprite().draw(batch);
        }
        progressView.getSprite().draw(batch);
        playerView.getSprite().draw(batch);
        batch.end();


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
