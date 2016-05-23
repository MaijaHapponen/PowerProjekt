package com.crap.game.view;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Maija on 2016-05-11.
 */
public class InteractionView extends ScreenAdapter{

    private Table table;
    private Table welcomeTable;
    private Stage stage;
    private Stage welcomeStage;
    private Viewport viewport;
    private int WorldWidth = 500;
    private int worldHeight = 500;
    private OrthographicCamera camera;
    private SpriteBatch batch;

    private String worldName;


    private Label talkLable = new Label(String.format("Press SPACE to talk"), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    private Label welcomeLabel = new Label(String.format("Welcome to " + worldName), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

    public InteractionView(){
        batch = new SpriteBatch();
        viewport = new FitViewport(WorldWidth, worldHeight, new OrthographicCamera());
        createInteraction();
        createWelcome();
    }

    public void createInteraction(){
        stage = new Stage(viewport, batch);
        table = new Table();
        table.top();
        table.setFillParent(true);
        table.add(talkLable);
        stage.addActor(table);
    }

    public void createWelcome(){
        welcomeStage = new Stage(viewport, batch);
        welcomeTable = new Table();
        welcomeTable.top();
        welcomeTable.setFillParent(true);
        welcomeTable.add(welcomeLabel);
        welcomeStage.addActor(welcomeTable);
    }

    @Override
    public void render(float delta) {

    }

    public Stage getStage(){
        return this.stage;
    }

    public Stage getWelcomeStage(){
        return this.welcomeStage;
    }
    public OrthographicCamera getCamera(){
        return this.camera;
    }


    public void setWorldName(String name){
        this.worldName = name;
    }

    public void setWelcomeLabel(Label label){
        this.welcomeLabel = label;
    }



}