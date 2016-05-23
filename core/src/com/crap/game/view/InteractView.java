package com.crap.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crap.game.model.Interact;


/**
 * Created by Maija on 2016-05-11.
 */
public class InteractView implements Screen{

    private SpriteBatch batch;
    private Stage stage;
    private int worldWidth = 500;
    private int worldHeight = 500;
    private TextureRegionDrawable background;
    private Interact interact;
    private Skin skin;

    BitmapFont titleFont;
    BitmapFont font;

    FreeTypeFontGenerator generator = new FreeTypeFontGenerator( Gdx.files.internal("fonts/Candy Shop.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

    Label[] answers;
    private Label questionLabel;
    private Label answerLabel1;
    private Label answerLabel2;
    private Label answerLabel3;
    private Label answerLabel4;


    public InteractView(){
        batch = new SpriteBatch();
        skin = new Skin();
        background = new TextureRegionDrawable(new TextureRegion(new Texture("background/rectangle.png")));
        create();


    }

    public void create(){



        parameter.size=20;
        titleFont = generator.generateFont(parameter);

        parameter.size=10;
        font= generator.generateFont(parameter);
        generator.dispose();

        questionLabel = new Label(String.format("This is a question"), new Label.LabelStyle(titleFont, Color.BLACK));
        answerLabel1= new Label(String.format("Alternative answer 1"), new Label.LabelStyle(font, Color.PINK));
        answerLabel2= new Label(String.format("Alternative answer 2"), new Label.LabelStyle(font, Color.PINK));
        answerLabel3= new Label(String.format("Alternative answer 3"), new Label.LabelStyle(font, Color.PINK));
        answerLabel4= new Label(String.format("Alternative answer 4"), new Label.LabelStyle(font, Color.PINK));
        //TODO get the strings from mascot through a get method

        Table table = new Table(skin);
        Viewport viewport = new FitViewport(worldHeight, worldWidth);
        this.stage = new Stage(viewport, batch);

        table.setBackground(background);
        table.center();
        table.add(questionLabel);
        table.row();
        table.add(answerLabel1);
        table.row();
        table.add(answerLabel2);
        table.row();
        table.add(answerLabel3);
        table.row();
        table.add(answerLabel4);

        table.setFillParent(true);

        stage.addActor(table);

        answers = new Label[]{answerLabel1, answerLabel2, answerLabel3, answerLabel4};
        interact = new Interact(answers, answerLabel1);
    }


    public Interact getInteractModel(){
        return this.interact;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        for(int i = 0; i < answers.length; i++) {
            if(interact.getCurrentLabelNbr() == i) {
                interact.getCurrentLabel().setColor(Color.PINK);
            }
            else{
                answers[i].setColor(Color.BLACK);
            }

            batch.setProjectionMatrix(stage.getCamera().combined);
            stage.draw();

        }

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
