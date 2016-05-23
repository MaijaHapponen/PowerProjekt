package com.crap.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by rebeccafinne on 16-05-23.
 */
public class CheckQuestionView implements Screen{


    private SpriteBatch batch;
    private BitmapFont information;
    private String givePlayerInformation = "Sorry you answered wrong, try again!";
    private String pressBackSpace = "Press backspace to return to game";



    public CheckQuestionView(){
        batch = new SpriteBatch();
        create();
    }


    public void create(){


        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Candy Shop.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size = 12;
        information = generator.generateFont(parameter);
        information.setColor(Color.BLACK);

        generator.dispose();




    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();

        information.draw(batch, givePlayerInformation, 60, 300);
        information.draw(batch, pressBackSpace, 60, 250);


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

    }
}
