package com.crap.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.crap.game.controller.StateController;
import com.crap.game.model.Menu;
import com.crap.game.model.State;


/**
 * Created by Maija on 2016-05-11.
 */
public class MenuView extends ScreenAdapter{

    private SpriteBatch batch;

    private BitmapFont titleFont;
    private BitmapFont font;

    private boolean gameOver;

    private Menu menuModel;

    public MenuView(boolean gameOver){
        this.gameOver = gameOver;
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

        String[] menuItems = new String[]{"Play the game", "How to play", "Exit"};
        menuModel = new Menu("C.R.A.P.", menuItems);
    }

    public Menu getMenuModel(){
        return this.menuModel;
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        if(!gameOver) {
            titleFont.draw(batch, menuModel.getGameName(), 60, 400);

            for (int i = 0; i < menuModel.amountOfItems(); i++) {
                if (menuModel.currentItemNumber() == i) {
                    font.setColor(Color.PINK);
                } else {
                    font.setColor(Color.BLACK);
                }

                font.draw(batch, menuModel.getMenuItem(i), 120, 250 - 70 * i);
            }

        }
        else{
            titleFont.draw(batch,"You win!", 60,400);
            titleFont.setColor(Color.PINK);

            font.draw(batch,"Press enter to return \n to main menu",60,220);
            font.setColor(Color.BLACK);
        }
        batch.end();
    }
    public void setScreen(){
        if(menuModel.getCurrentItem().equals("Play the game")){
            StateController.updateState(State.GameStates.PLAY);
            dispose();
        }else if(menuModel.getCurrentItem().equals("How to play")){
            StateController.updateState(State.GameStates.HOWTOPLAY);
        }else if(menuModel.getCurrentItem().equals("Exit")){
            System.exit(0);
        }
    }

    public boolean getGameOver(){
        return this.gameOver;
    }

    public void setGameOver(boolean state){
        this.gameOver = state;
    }

    @Override
    public void dispose() {
        batch.dispose();
        titleFont.dispose();
        font.dispose();
    }
}
