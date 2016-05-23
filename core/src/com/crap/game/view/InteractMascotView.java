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
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crap.game.model.*;
import com.crap.game.model.Character;
import com.crap.game.model.InteractMascot;


/**
 * Created by Maija on 2016-05-11.
 */
public class InteractMascotView implements Screen{

    private SpriteBatch batch;

    private Character interactionCharacter;

    private Stage stage;
    private int worldWidth = 500;
    private int worldHeight = 500;
    private TextureRegionDrawable background;
    private InteractMascot interactMascot;

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





    public InteractMascotView(){
        batch = new SpriteBatch();
        skin = new Skin();
        background = new TextureRegionDrawable(new TextureRegion(new Texture("background/rectangle.png")));

        create();
    }

    public void create(){

        String question = getQuestion(interactionCharacter);
        java.util.List<String> alternatives = getAnswers(interactionCharacter);

        parameter.size=20;
        titleFont = generator.generateFont(parameter);

        parameter.size=10;
        font= generator.generateFont(parameter);
        generator.dispose();

        questionLabel = new Label(String.format(question), new Label.LabelStyle(titleFont, Color.BLACK));
        answerLabel1= new Label(String.format(alternatives.get(0)), new Label.LabelStyle(font, Color.PINK));
        answerLabel2= new Label(String.format(alternatives.get(1)), new Label.LabelStyle(font, Color.PINK));
        answerLabel3= new Label(String.format(alternatives.get(0)), new Label.LabelStyle(font, Color.PINK));
        answerLabel4= new Label(String.format(alternatives.get(0)), new Label.LabelStyle(font, Color.PINK));

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
        interactMascot = new InteractMascot(answers, answerLabel1);
    }
    public String getQuestion(Character interactionCharacter){
        if(interactionCharacter instanceof Mascot){
            return ((Mascot) interactionCharacter).getQuestion().getQuestion();
        }
        return null;
    }

    public java.util.List<String> getAnswers(Character interactionCharacter) {
        if (interactionCharacter instanceof Mascot) {
            return ((Mascot) interactionCharacter).getQuestion().getAlternatives();
        }
        return null;
    }



    public InteractMascot getInteractModel(){
        return this.interactMascot;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        for(int i = 0; i < answers.length; i++) {
            if(interactMascot.getCurrentLabelNbr() == i) {
                interactMascot.getCurrentLabel().setColor(Color.PINK);
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
        stage.dispose();

    }
    public void hide() {}

}
