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
import com.crap.game.model.TextForInteraction;

/**
 * Created by Maija on 2016-05-11.
 */
public class InteractionView extends ScreenAdapter{

    private Table table;
    private Table welcomeTable;
    private Stage stage;
    private Stage welcomeStage;
    private Viewport viewport;

    private float worldWidth;
    private float worldHeight;

    private SpriteBatch batch;

    private Label talkLable = new Label(String.format(TextForInteraction.talkToCharacter),
            new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    private Label welcomeLabel;

    private Label hubbenLabel = new Label(String.format(TextForInteraction.welcomeToHubben),
            new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    private Label zaloonenLabel= new Label(String.format(TextForInteraction.welcomeToZaloonen),
            new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    private Label horsalLabel = new Label(String.format(TextForInteraction.welcomeToHorsalsvagen),
            new Label.LabelStyle(new BitmapFont(), Color.WHITE));

    public InteractionView(GameView view){
        worldHeight = view.getWorldHeight();
        worldWidth = view.getWorldWidth();
        batch = new SpriteBatch();
        viewport = new FitViewport(worldWidth, worldHeight, new OrthographicCamera());
        createInteraction();
        createWelcome();
    }

    public void createInteraction(){
        getWelcomeLabel();
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


    public Stage getStage(){
        return this.stage;
    }

    public Stage getWelcomeStage(){
        return this.welcomeStage;
    }


    public void setWelcomeLabel(String world){
        if(world.equals("hubben")){
            welcomeLabel = hubbenLabel;
        }if(world.equals("zaloonen")){
            welcomeLabel = zaloonenLabel;
        }else{
            welcomeLabel = horsalLabel;
        }
    }

    public Label getWelcomeLabel(){
        return this.welcomeLabel;
    }

    public void dispose(){
        stage.dispose();
        welcomeStage.dispose();
        batch.dispose();
    }
}