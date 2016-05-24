package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crap.game.model.*;
import com.crap.game.model.Character;

import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;

/**
 * Created by Maija on 2016-04-21.
 */
public class GameView extends ApplicationAdapter implements Screen{

    private SpriteBatch batch;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private float elapsedTime;

    private int pixelPerTile = 30;
    public static TiledMap world;
    private PlayerView playerView;

    private ProgressView progressView;
    private Progress progress;
    private Character character;
    private InteractionView interactionView;

    private boolean interaction;
    private boolean newWorld;
    private boolean isStart;
    private Label label;
    private Stage stage;
    private Table table;
    private Viewport viewport;
    private int WorldWidth = 500;
    private int worldHeight = 500;

    private ArrayList<CharacterView> humansList = new ArrayList<CharacterView>();
    private ArrayList<CharacterView> mascotsList = new ArrayList<CharacterView>();

    private ArrayList<ProgressView> mascotsOnBar = new ArrayList<ProgressView>();


    public GameView(Game game){


        this.isStart = true;
        this.world = new TmxMapLoader().load("maps/horsalmaskin.tmx");
        this.playerView = new PlayerView();
        batch = new SpriteBatch();
        this.progressView = new ProgressView(game.getProgress());


        renderer = new OrthogonalTiledMapRenderer(world);


        this.playerView = new PlayerView();
        this.interactionView = new InteractionView();
        viewport = new FitViewport(WorldWidth, worldHeight, new OrthographicCamera());


        setLabel("hörsalsvägen");
        create();
    }

    @Override
    public void show() {
    }

    public void create(){
        interactionView.createWelcome();
    }

    @Override
    public void render(float delta) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        this.camera = playerView.getCamera();
        renderer.setView(camera);

        batch.setProjectionMatrix(camera.combined);

        renderer.render();

        batch.begin();

        for(int i = 0; i<humansList.size(); i++){
            batch.draw(humansList.get(i).getAnimation().getKeyFrame(elapsedTime,true),
                    humansList.get(i).getCharacter().getPosition().getX(),
                    humansList.get(i).getCharacter().getPosition().getY());
        }

        for(int i = 0; i<mascotsList.size(); i++){
            batch.draw(mascotsList.get(i).getAnimation().getKeyFrame(elapsedTime,true),
                    mascotsList.get(i).getCharacter().getPosition().getX(),
                    mascotsList.get(i).getCharacter().getPosition().getY());
        }

        batch.draw(playerView.getAnimation().getKeyFrame(elapsedTime, true), playerView.getPlayerPosition().getX(),
                playerView.getPlayerPosition().getY());

        batch.end();

        batch.setProjectionMatrix(progressView.getStage().getCamera().combined);
        progressView.getStage().draw();

        if(isStart){
            setLabel("hörsalsvägen");
            batch.setProjectionMatrix(interactionView.getWelcomeStage().getCamera().combined);
            interactionView.getWelcomeStage().draw();
            if(interaction){
                newWorld = false;
                interactionView.getWelcomeStage().dispose();

            }
        }

        if(interaction){
            batch.setProjectionMatrix(interactionView.getStage().getCamera().combined);
            interactionView.getStage().draw();
        }

        if(newWorld){

            interactionView.getWelcomeLabel();
            batch.setProjectionMatrix(interactionView.getWelcomeStage().getCamera().combined);
            interactionView.getWelcomeStage().draw();
            if(interaction){
                newWorld = false;
                interactionView.getWelcomeStage().dispose();

            }

        }


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
    }

    @Override
    public void dispose() {
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

    public void setInteraction(boolean b){
        interaction = b;
    }
    public boolean isInteraction(){
        return interaction;
    }

    public ArrayList<CharacterView> getHumansList(){
        return this.humansList;
    }

    public ArrayList<CharacterView> getMascotsList(){
        return this.mascotsList;
    }

    public void setMascotsOnBar(ArrayList<Mascot> mascotsOnBarl){
        for(int i = 0; i < mascotsOnBarl.size(); i++){
        //    this.mascotsOnBar.add(new ProgressView());
        }
    }

    public void setWorld(TiledMap world) {
        this.world = world;
        this.renderer = new OrthogonalTiledMapRenderer(this.world);
    }

    public void setCamera(OrthographicCamera camera) {
        playerView.setCamera(camera);
    }

    public PlayerView getPlayerView(){
        return this.playerView;
    }

    public float getWorldWidth(){
        return this.world.getProperties().get("width", Integer.class)*pixelPerTile;
    }

    public float getWorldHeight(){
        return this.world.getProperties().get("height", Integer.class)*pixelPerTile;
    }

    public TiledMap getWorld() {
        return this.world;
    }

    public void setNewWorld(boolean b){
        this.newWorld = b;
    }

    public void setLabel(String world){
        if(world.equals("hubben")){
            interactionView.setWelcomeLabel("hubben");
        }if(world.equals("zaloonen")){
            interactionView.setWelcomeLabel("zaloonen");
        }else{
            interactionView.setWelcomeLabel("hörsalsvägen");
        }
    }


}
