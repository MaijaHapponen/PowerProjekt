package com.crap.game.view.interaction;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crap.game.model.information.TextForInteraction;

public class InteractionView extends ScreenAdapter{

    private Stage stage;
    private Stage welcomeStage;
    private Viewport viewport;

    private SpriteBatch batch;

    private Label talkLable;
    private Label welcomeLabel;
    private Label hubbenLabel;
    private Label zaloonenLabel;
    private Label horsalLabel;
    private Label hiddenRoomLabel;

    public InteractionView(){
        int worldWidth = Gdx.graphics.getWidth();
        int worldHeight = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        viewport = new FitViewport(worldWidth, worldHeight, new OrthographicCamera());
        createLabels();
        createInteraction();
        createWelcome();
    }

    public void createLabels(){

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator( Gdx.files.internal("fonts/Candy Shop.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size = TextForInteraction.interactionFontSize;
        BitmapFont font = generator.generateFont(parameter);

        hubbenLabel = new Label(String.format(TextForInteraction.welcomeToHubben),
                new Label.LabelStyle(font, Color.WHITE));
        zaloonenLabel = new Label(String.format(TextForInteraction.welcomeToZaloonen),
                new Label.LabelStyle(font, Color.WHITE));
        horsalLabel = new Label(String.format(TextForInteraction.welcomeToHorsalsvagen),
                new Label.LabelStyle(font, Color.WHITE));
        talkLable = new Label(String.format(TextForInteraction.talkToCharacter),
                new Label.LabelStyle(font, Color.WHITE));
        hiddenRoomLabel = new Label(String.format(TextForInteraction.hiddenRoom),
                new Label.LabelStyle(font, Color.WHITE));

    }

    public void createInteraction(){
        getWelcomeLabel();
        stage = new Stage(viewport, batch);
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        table.add(talkLable);
        stage.addActor(table);
    }

    public void createWelcome(){
        welcomeStage = new Stage(viewport, batch);
        Table welcomeTable = new Table();
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
        }if(world.equals("hörsalsvägen")){
            welcomeLabel = horsalLabel;
        }if(world.equals("hiddenroom")){
            welcomeLabel = hiddenRoomLabel;
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