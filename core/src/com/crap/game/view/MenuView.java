package com.crap.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.crap.game.Main;
import com.crap.game.model.State;


/**
 * Created by Maija on 2016-05-11.
 */
public class MenuView implements Screen{

    private SpriteBatch batch;

    private BitmapFont titleFont;
    private BitmapFont font;

    private String gameName = "C.R.A.P.";

    private int currentItemNr;
    private String currentItem;
    private String[] menuItems;


    public MenuView(){
        batch = new SpriteBatch();
        create();
    }
    public void create(){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator( Gdx.files.internal("fonts/Candy Shop.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size=50;
        titleFont = generator.generateFont(parameter);
        titleFont.setColor(Color.BLACK);

        parameter.size=20;
        font= generator.generateFont(parameter);
        generator.dispose();

        menuItems = new String[]{"Play the game", "How to play", "Exit"};
        currentItemNr =0;
        currentItem = menuItems[currentItemNr];
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();
        titleFont.draw(batch, gameName, 60, 400);

        for(int i = 0; i<menuItems.length;i++){
            if(currentItemNr ==i){font.setColor(Color.PINK);}
            else{font.setColor(Color.BLACK);}

            font.draw(batch, menuItems[i], 120, 250 - 70*i);
        }
        batch.end();

    }

    public void setCurrentItem(String direction){
        if(direction.equals("up")){
            if(currentItemNr == 0) currentItemNr =2;
            else currentItemNr = currentItemNr -1;

        }else if(direction.equals("down")){
            if(currentItemNr == 2) currentItemNr = 0;
            else currentItemNr = currentItemNr + 1;
        }
        currentItem = menuItems[currentItemNr];
    }

    public void setScreen(){
        if(currentItem.equals("Play the game")){
            State.updateState(State.GameStates.PLAY);
            dispose();
        }else if(currentItem.equals("How to play")){

        }else if(currentItem.equals("Exit")){
            System.exit(0);
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
