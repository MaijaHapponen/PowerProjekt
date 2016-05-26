package com.crap.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.crap.game.model.Menu;
import com.crap.game.model.TextForInteraction;

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

        parameter.size=TextForInteraction.titleFontSize*2;
        titleFont = generator.generateFont(parameter);
        titleFont.setColor(Color.BLACK);

        parameter.size=TextForInteraction.instructionFontSize;
        font= generator.generateFont(parameter);
        generator.dispose();

        String[] menuItems = new String[]{TextForInteraction.playTheGame, TextForInteraction.howToPlay,
                TextForInteraction.exit};
        menuModel = new Menu(TextForInteraction.gameName, menuItems);
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
            titleFont.draw(batch, menuModel.getGameName(), TextForInteraction.titlePlacementX,
                    TextForInteraction.titlePlacementY);

            for (int i = 0; i < menuModel.amountOfItems(); i++) {
                if (menuModel.currentItemNumber() == i) {
                    font.setColor(Color.PINK);
                } else {
                    font.setColor(Color.BLACK);
                }

                font.draw(batch, menuModel.getMenuItem(i), TextForInteraction.alternativesPlacementX,
                        TextForInteraction.alternativesPlacementY - TextForInteraction.spaceBetweenAlternatives * i);
            }

        }
        else{
            titleFont.draw(batch,TextForInteraction.winTheGame, TextForInteraction.titlePlacementX,
                    TextForInteraction.titlePlacementY);
            titleFont.setColor(Color.BLACK);

            font.draw(batch,TextForInteraction.returnToMainMenu,TextForInteraction.alternativesPlacementX,
                    TextForInteraction.alternativesPlacementY);
            font.setColor(Color.PINK);
        }
        batch.end();
    }

    //TODO: Move to Menu
    public boolean getGameOver(){
        return this.gameOver;
    }

    @Override
    public void dispose() {
        batch.dispose();
        titleFont.dispose();
        font.dispose();
    }
}
