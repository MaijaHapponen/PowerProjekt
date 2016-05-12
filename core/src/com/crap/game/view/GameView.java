package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crap.game.model.*;
import com.badlogic.gdx.math.Intersector;
import com.crap.game.model.Character;
import com.sun.prism.image.ViewPort;

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

   // private Viewport fillViewport1;

   // private Viewport fillViewport2;







    private ArrayList<CharacterView> humansList = new ArrayList<CharacterView>();
    private ArrayList<CharacterView> mascotsList = new ArrayList<CharacterView>();
    private ArrayList<ProgressView> mascotsOnBar = new ArrayList<ProgressView>();


    public GameView(){

        this.batch = new SpriteBatch();
        this.level = "horsalmaskin";

        this.playerView = new PlayerView();
        this.progressView = new ProgressView();

        map = new TmxMapLoader().load("maps/"+level+".tmx");
        renderer = new OrthogonalTiledMapRenderer(map);








        //fillViewport1 = new FillViewport(500, 500);
       // fillViewport2 = new FillViewport(100, 100);


    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        //Gdx.gl.glViewport(0, 100, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //fillViewport1.apply();



        this.camera = playerView.getCamera();
        renderer.setView(camera);




        batch.setProjectionMatrix(camera.combined);



        renderer.render();

        batch.begin();


        playerView.getSprite().draw(batch);

        for(int i = 0; i<humansList.size(); i++){
            humansList.get(i).getSprite().draw(batch);
        }
        for(int i = 0; i<mascotsList.size(); i++){
            mascotsList.get(i).getSprite().draw(batch);
        }


       /* for(int i = 0; i < mascotsOnBar.size(); i++ ){
            mascotsOnBar.get(i).getSpriteMascots().draw(batch);

        }*/
        batch.end();

        batch.setProjectionMatrix(progressView.getStage().getCamera().combined);
        progressView.getStage().draw();


    }

    @Override
    public void resize(int width, int height) {

        //fillViewport1.update(width, height);

        //fillViewport2.update(width, height);
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
            this.mascotsOnBar.add(new ProgressView());
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
