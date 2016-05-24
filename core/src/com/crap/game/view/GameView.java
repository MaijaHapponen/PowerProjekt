package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crap.game.model.*;
import com.crap.game.model.Character;

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

    private Game game;
    private ProgressView progressView;
    private Progress progress;
    private InteractionView interactionView;

    private boolean interaction;
    private boolean newWorld;
    private boolean isStart;
    private Viewport viewport;

    private int worldWidth = Gdx.graphics.getWidth();
    private int worldHeight = Gdx.graphics.getHeight();

    private ArrayList<CharacterView> humansList = new ArrayList<CharacterView>();
    private ArrayList<CharacterView> mascotsList = new ArrayList<CharacterView>();

    public GameView(Game game){
        this.isStart = true;

        this.game = game;
        this.world = new TmxMapLoader().load("maps/horsalmaskin.tmx");
        this.playerView = new PlayerView();
        batch = new SpriteBatch();
        this.progress = game.getProgress();
        this.progressView = new ProgressView(progress);

        renderer = new OrthogonalTiledMapRenderer(world);

        this.interactionView = new InteractionView();
        
        viewport = new FitViewport(worldWidth, worldHeight, new OrthographicCamera());

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
            if(humansList.get(i).getCharacter().getWorld() == game.getCurrectWorld()){
                batch.draw(humansList.get(i).getAnimation().getKeyFrame(elapsedTime, true),
                        humansList.get(i).getCharacter().getPosition().getX(),
                        humansList.get(i).getCharacter().getPosition().getY());
            }
        }

        for(int i = 0; i<mascotsList.size(); i++){
            Mascot tempMascot = (Mascot) mascotsList.get(i).getCharacter();
            if(tempMascot.getWorld() == game.getCurrectWorld() && !tempMascot.isCaught()){
                batch.draw(mascotsList.get(i).getAnimation().getKeyFrame(elapsedTime,true),
                        tempMascot.getPosition().getX(),
                        tempMascot.getPosition().getY());
            }
        }

        batch.draw(playerView.getAnimation().getKeyFrame(elapsedTime, true), playerView.getPlayerPosition().getX(),
                playerView.getPlayerPosition().getY());

        batch.end();

        if(progress.newUpdate()){
            progressView.updateProgressBar();
            progress.setNewUpdate(false);
        }

        progressView.drawStage();
        batch.setProjectionMatrix(progressView.getStage().getCamera().combined);

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

    public Game getGame(){
        return this.game;
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

    public float getTileHeight(){
        return this.world.getProperties().get("tilewidth", Integer.class);
    }

    public float getTileWidth() {
        return this.world.getProperties().get("tileheight", Integer.class);
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
