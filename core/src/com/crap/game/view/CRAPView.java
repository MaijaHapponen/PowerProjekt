package com.crap.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crap.game.model.*;

import java.util.ArrayList;

import static com.crap.game.model.Constants.PIXEL_PER_TILE;

/**
 * Created by Maija on 2016-04-21.
 */
public class CRAPView extends ScreenAdapter{

    private SpriteBatch batch;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private float elapsedTime;

    public TiledMap world;
    private PlayerView playerView;

    private CRAP CRAP;
    private ProgressView progressView;
    private Progress progress;
    private InteractionView interactionView;

    private boolean interaction;
    private boolean isStart;
    private Viewport viewport;

    private int worldWidth = Constants.SCREEN_WIDTH;
    private int worldHeight = Constants.SCREEN_HEIGHT;

    private ArrayList<CharacterView> humansList = new ArrayList<CharacterView>();
    private ArrayList<CharacterView> mascotsList = new ArrayList<CharacterView>();

    public CRAPView(CRAP CRAP){
        this.isStart = true;

        this.CRAP = CRAP;
        this.world = new TmxMapLoader().load("maps/horsalmaskin.tmx");
        this.playerView = new PlayerView();
        batch = new SpriteBatch();
        this.progress = CRAP.getProgress();
        this.progressView = new ProgressView(progress);

        renderer = new OrthogonalTiledMapRenderer(world);

        this.interactionView = new InteractionView();
        
        viewport = new FitViewport(worldWidth, worldHeight, new OrthographicCamera());

        createWelcome();
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

        drawHumans();
        drawMascots();

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
                CRAP.setNewWorld(false);
                interactionView.getWelcomeStage().dispose();

            }
        }

        if(interaction){
            batch.setProjectionMatrix(interactionView.getStage().getCamera().combined);
            interactionView.getStage().draw();
        }

        if(CRAP.getNewWorld()){
            interactionView.getWelcomeLabel();
            batch.setProjectionMatrix(interactionView.getWelcomeStage().getCamera().combined);
            interactionView.getWelcomeStage().draw();
            if(interaction){
                CRAP.setNewWorld(false);
                interactionView.getWelcomeStage().dispose();

            }
        }
    }

    public void createWelcome(){
        interactionView.createWelcome();
    }

    public void drawHumans(){
        for(int i = 0; i<humansList.size(); i++){
            if(humansList.get(i).getCharacter().getWorld() == CRAP.getCurrentWorld()){
                batch.draw(humansList.get(i).getAnimation().getKeyFrame(elapsedTime, true),
                        humansList.get(i).getCharacter().getPosition().getX(),
                        humansList.get(i).getCharacter().getPosition().getY());
            }
        }
    }

    public void drawMascots(){
        for(int i = 0; i<mascotsList.size(); i++){
            Mascot tempMascot = (Mascot) mascotsList.get(i).getCharacter();
            if(tempMascot.getWorld() == CRAP.getCurrentWorld() && !tempMascot.isCaught()){
                batch.draw(mascotsList.get(i).getAnimation().getKeyFrame(elapsedTime,true),
                        tempMascot.getPosition().getX(),
                        tempMascot.getPosition().getY());
            }
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        renderer.dispose();
        playerView.dispose();

        world.dispose();
        progressView.dispose();
        interactionView.dispose();
        for (int i=0; i<humansList.size(); i++) {
            humansList.get(i).dispose();
        }
        for (int i=0; i<mascotsList.size(); i++) {
            mascotsList.get(i).dispose();
        }
    }

    public CRAP getCRAP(){
        return this.CRAP;
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

    public void setWorld(TiledMap world) {
        this.world = world;
        this.renderer = new OrthogonalTiledMapRenderer(this.world);
    }

    public PlayerView getPlayerView(){
        return this.playerView;
    }

    public float getWorldWidth(){
        return this.world.getProperties().get("width", Integer.class)* PIXEL_PER_TILE;
    }

    public float getWorldHeight(){
        return this.world.getProperties().get("height", Integer.class)* PIXEL_PER_TILE;
    }

    public TiledMap getWorld() {
        return this.world;
    }

    public void setLabel(String world){
        if(world.equals("hubben")){
            interactionView.setWelcomeLabel("hubben");
        }if(world.equals("zaloonen")){
            interactionView.setWelcomeLabel("zaloonen");
        }if(world.equals("hörsalsvägen")){
            interactionView.setWelcomeLabel("hörsalsvägen");
        }if(world.equals("hiddenroom")){
            interactionView.setWelcomeLabel(("hiddenroom"));
        }if(world.equals("remove")){
            interactionView.setWelcomeLabel("remove");
        }
    }
}
