package com.crap.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;



/**
 * Created by Maija on 2016-05-11.
 */
public class InteractView implements Screen{

    private SpriteBatch batch;
    private Batch drawableBatch;
    private Stage stage;
    private int worldWidth = 500;
    private int worldHeight = 500;
    private TextureRegionDrawable background;
    TextureAtlas buttonAtlas;
    BitmapFont font;



    private Skin skin;



    TextButton buttonPlay;

    private Label questionLabel = new Label(String.format("This is a question"), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
    //TODO get the strings from mascot through a get method
    private Label answerLabel= new Label(String.format("Alternative answer"), new Label.LabelStyle(new BitmapFont(), Color.BLACK));



    public InteractView(){
        batch = new SpriteBatch();
        skin = new Skin();
        background = new TextureRegionDrawable(new TextureRegion(new Texture("background/rectangle.png")));
       // buttonAtlas = new TextureAtlas("assets/fonts/Candy Shop.ttf");
       // font = new BitmapFont();



        create();


    }

    public void create(){
        //skin.addRegions(buttonAtlas);
        Table table = new Table(skin);
        Viewport viewport = new FitViewport(worldHeight, worldWidth);
        this.stage = new Stage(viewport, batch);
       // TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        //buttonStyle.font = font;

        //buttonPlay = new TextButton("Play", buttonStyle);

        table.setSize(500, 300);
        table.setBackground(background);
        table.bottom();
        table.padBottom(50);
        table.add(questionLabel);
        table.row();
        table.add(answerLabel);

        table.setFillParent(true);

        stage.addActor(table);

    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        batch.setProjectionMatrix(stage.getCamera().combined);
        stage.draw();



    }

    @Override
    public void resize(int width, int height) {

        this.worldHeight = height;
        this.worldWidth = width;

    }


    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();

    }
    public void hide() {}

}
