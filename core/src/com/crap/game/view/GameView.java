package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.crap.game.model.*;
import com.badlogic.gdx.math.Intersector;

import java.lang.Character;
import java.util.ArrayList;

/**
 * Created by Maija on 2016-04-21.
 */
public class GameView extends ApplicationAdapter implements Screen{

    private SpriteBatch batch;
    public static TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private String level;
    private TiledMap world;
    private OrthographicCamera camera;
    private Sprite sprite;

    private PlayerView playerView;
    private ProgressView progressView;
    private Progress progress;
    private Character character;



    private ArrayList<CharacterView> humansList = new ArrayList<CharacterView>();
    private ArrayList<CharacterView> mascotsList = new ArrayList<CharacterView>();
    private ArrayList<ProgressView> mascotsOnBar = new ArrayList<ProgressView>();


    public GameView(){

        this.batch = new SpriteBatch();
        this.level = "horsalmaskin";

        this.playerView = new PlayerView();
        this.progressView = new ProgressView(character);

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


        for(int i = 0; i < mascotsOnBar.size(); i++ ){
            mascotsOnBar.get(i).getSpriteMascots().draw(batch);

        }

        progressView.getSpriteBack().draw(batch);
        playerView.getSprite().draw(batch);
        batch.end();


    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
    }

    public void setPlayer(Player player){
        playerView.setPlayer(player);
    }

    public void setHumans(ArrayList<Human> humans){
        for (int i=0; i<humans.size(); i++) {
            this.humansList.add(new CharacterView(humans.get(i)));
        }
    }

    public void setMascots(ArrayList<Mascot> mascots){
        for (int i=0; i<mascots.size(); i++) {
            this.mascotsList.add(new CharacterView(mascots.get(i)));
        }
    }

    public void setMascotsOnBar(ArrayList<Mascot> mascotsOnBarl){
        for(int i = 0; i < mascotsOnBarl.size(); i++){
            this.mascotsOnBar.add(new ProgressView(character));
        }
    }

    public void setWorld(TiledMap world) { this.world = world; }

    public void setCamera(OrthographicCamera camera) {
        playerView.setCamera(camera);
    }

    public PlayerView getPlayerView(){
        return this.playerView;
    }
}
