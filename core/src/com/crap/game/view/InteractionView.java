package com.crap.game.view;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.crap.game.Main;
import com.crap.game.controller.InteractionController;

/**
 * Created by Maija on 2016-05-11.
 */
public class InteractionView extends GameView{

    private SpriteBatch batch;
    private BitmapFont font;


    public InteractionView(){
        super();
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.draw(batch, "Welcome to C.R.A.P. the game!", 100, 150);
        font.draw(batch, "Click enter to begin.", 100, 100);
        batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            System.exit(0);
            dispose();
        }
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
        font.dispose();
    }
}