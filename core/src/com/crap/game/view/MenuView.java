package com.crap.game.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.crap.game.Main;


/**
 * Created by Maija on 2016-05-11.
 */
public class MenuView implements Screen{

    private SpriteBatch batch;

    private BitmapFont titleFont;
    private BitmapFont font;

    private String gameName = "C.R.A.P.";

    private String currentItem;
    private String[] menuItems;


    private Main main;

    public MenuView(Main g){
        this.main = g;
        batch = new SpriteBatch();
        create();

    }
    public void create(){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator( Gdx.files.internal("fonts/Candy Shop.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size=50;
        titleFont = generator.generateFont(parameter);
        titleFont.setColor(Color.BLACK);

        parameter.size=14;
        font= generator.generateFont(parameter);
        font.setColor(Color.PINK);
        generator.dispose();

        menuItems = new String[]{"Play the game", "How to play", "Exit"};
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        titleFont.draw(batch,gameName , 60, 400);
        font.draw(batch, "Click enter to begin.", 100, 200);
        batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            main.setScreen(main.getWorldView());
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
        titleFont.dispose();

        font.dispose();
    }
}
