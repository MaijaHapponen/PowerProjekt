package com.crap.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by rebeccafinne on 16-05-23.
 */
public class InteractHumanView extends ScreenAdapter {

    SpriteBatch batch;
    BitmapFont title;
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Candy Shop.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    private String chooseOption = "Hello! What do you want to know more about?";

    public InteractHumanView(){

        batch = new SpriteBatch();
        create();
    }

    public void create(){

        parameter.size = 12;
        title = generator.generateFont(parameter);

        generator.dispose();
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        title.draw(batch, chooseOption, 30, 400);

        batch.end();
    }
}
