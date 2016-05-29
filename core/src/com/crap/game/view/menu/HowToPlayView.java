package com.crap.game.view.menu;

import com.crap.game.model.information.TextForInteraction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
/**
 * Created by rebeccafinne on 2016-05-17.
 */
public class HowToPlayView extends ScreenAdapter{

    private String[] instructionItems;

    private BitmapFont titleFont;
    private BitmapFont instructionFont;
    private BitmapFont pressBackFont;
    private SpriteBatch batch;

    public HowToPlayView(){
        batch = new SpriteBatch();
        create();
    }

    public void create(){

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Candy Shop.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = TextForInteraction.titleFontSize;
        titleFont = generator.generateFont(parameter);

        parameter.size = TextForInteraction.instructionFontSize;
        instructionFont = generator.generateFont(parameter);

        parameter.size = TextForInteraction.returnFontSize;
        pressBackFont = generator.generateFont(parameter);

        generator.dispose();
        
        instructionItems = new String[]{TextForInteraction.howToPlay1, TextForInteraction.howToPlay2,
                TextForInteraction.howToPlay3, TextForInteraction.howToPlay4};
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        titleFont.setColor(Color.BLACK);
        titleFont.draw(batch, TextForInteraction.howToPlayTitle, TextForInteraction.titlePlacementX,
                TextForInteraction.titlePlacementY);

        for(int i = 0; i < instructionItems.length; i++){
            float rowDistance = TextForInteraction.spaceBetweenAlternatives;
            instructionFont.setColor(Color.BLACK);
            instructionFont.draw(batch, instructionItems[i], TextForInteraction.alternativesPlacementX,
                    TextForInteraction.howToPlayInstructionsPlacementY - rowDistance * i);
        }

        pressBackFont.setColor(Color.PINK);
        pressBackFont.draw(batch, TextForInteraction.returnMenu, TextForInteraction.alternativesPlacementX,
                TextForInteraction.returnPlacementY);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        titleFont.dispose();
        instructionFont.dispose();
        pressBackFont.dispose();
    }
}
