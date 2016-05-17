package com.crap.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by rebeccafinne on 2016-05-17.
 */
public class HowToPlayView implements Screen{

    private String title = "This is how you play C.R.A.P the game";
    private String instructions = "Catch al the mascots to win";
    private String instructions2 = "Answer the questions right to catch the mascot";
    private String instructions3 = "Move with the key arrows";

    private String[] instructionItems;

    private BitmapFont titleFont;
    private BitmapFont instructionFont;
    private SpriteBatch batch;

    public HowToPlayView(){
        batch = new SpriteBatch();
        create();
    }

    public void create(){

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Candy Shop.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 50;
        titleFont = generator.generateFont(parameter);

        parameter.size = 15;
        instructionFont = generator.generateFont(parameter);
        generator.dispose();

        instructionItems = new String[]{instructions, instructions2, instructions3};

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        batch.begin();

        titleFont.draw(batch, title, 10, 10);



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
}
