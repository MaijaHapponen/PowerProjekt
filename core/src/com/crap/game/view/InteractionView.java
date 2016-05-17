package com.crap.game.view;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crap.game.Main;
import com.crap.game.model.*;
import com.crap.game.model.Game;

/**
 * Created by Maija on 2016-05-11.
 */
public class InteractionView implements Screen{

    private Table table;
    private Stage stage;
    private Viewport viewport;
    private int talkBubbleWidth = 500;
    private int talkBubbleHeight = 500;
    private OrthographicCamera camera;
    private SpriteBatch batch;


    private Label talkLable = new Label(String.format("Hello I'm a mascot!"), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    private Label answerOne= new Label(String.format("Answer one"), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

    private Label answerTwo = new Label(String.format("Answer two"), new Label.LabelStyle(new BitmapFont(), Color.WHITE));


    public InteractionView(){
        batch = new SpriteBatch();
        viewport = new FitViewport(talkBubbleWidth, talkBubbleHeight, new OrthographicCamera());
        stage = new Stage(viewport, batch);
        table = new Table();
        table.top();
        table.setFillParent(true);
        table.add(talkLable);
        table.row();
        table.add(answerOne);
        table.add(answerTwo);
        stage.addActor(table);



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {


        stage.draw();




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
    }

    public Stage getStage(){
        return this.stage;
    }

    public OrthographicCamera getCamera(){
        return this.camera;
    }

}