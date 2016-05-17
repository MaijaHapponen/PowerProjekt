package com.crap.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by rebeccafinne on 2016-05-17.
 */
public class HowToPlayView implements Screen{

    private String title = "This is how you play";
    private String instructions = "-Catch all the mascots to win";
    private String instructions2 = "-Answer the questions " ;
    private String instructions25 = "right to catch the mascot";
    private String instructions4 = "-Move with the key arrows";
    private String instructions3 = "-Interact by pressing xxxxxxx";
    private String pressEnter = "Press enter to begin the game";

    private String[] instructionItems;

    private BitmapFont titleFont;
    private BitmapFont instructionFont;
    private BitmapFont pressEnterFont;
    private SpriteBatch batch;
    private float rowDistance = 60;

    public HowToPlayView(){
        batch = new SpriteBatch();
        create();
    }

    public void create(){

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Candy Shop.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 27;
        titleFont = generator.generateFont(parameter);

        parameter.size = 18;
        instructionFont = generator.generateFont(parameter);

        parameter.size = 18;
        pressEnterFont = generator.generateFont(parameter);

        generator.dispose();

        instructionItems = new String[]{instructions, instructions2, instructions25, instructions3, instructions4};

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        titleFont.setColor(Color.BLACK);

        titleFont.draw(batch, title, 30, 500);

        for(int i = 0; i < instructionItems.length; i++){
            instructionFont.setColor(Color.BLACK);
            instructionFont.draw(batch, instructionItems[i], 30, 400 - rowDistance * i);
        }

        pressEnterFont.setColor(Color.PINK);
        pressEnterFont.draw(batch, pressEnter, 30, 100);


        batch.end();


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
        batch.dispose();
        titleFont.dispose();
        instructionFont.dispose();
    }
}
