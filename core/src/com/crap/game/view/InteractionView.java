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
    private Stage stage;
    private Viewport viewport;
    private int WorldWidth = 500;
    private int worldHeight = 500;
    private OrthographicCamera camera;
    private SpriteBatch batch;


    private Label talkLable = new Label(String.format("Press SPACE to talk"), new Label.LabelStyle(new BitmapFont(),
            Color.WHITE));


    public InteractionView(){
        batch = new SpriteBatch();
        viewport = new FitViewport(WorldWidth, worldHeight, new OrthographicCamera());
        stage = new Stage(viewport, batch);
        table = new Table();
        table.top();
        table.setFillParent(true);
        table.add(talkLable);
        table.row();
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(stage.getCamera().combined);
        stage.draw();
    }

    public Stage getStage(){
        return this.stage;
    }

    public OrthographicCamera getCamera(){
        return this.camera;
    }

}