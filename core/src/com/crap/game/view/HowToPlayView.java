package com.crap.game.view;

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
        parameter.size = 27;
        titleFont = generator.generateFont(parameter);

        parameter.size = 18;
        instructionFont = generator.generateFont(parameter);

        parameter.size = 18;
        pressBackFont = generator.generateFont(parameter);

        generator.dispose();
        String instructions = "-Catch all the mascots to win.";
        String instructions2 = "-Answer the questions\nnextStepRight to catch the mascot.";
        String instructions3 = "\n-Interact with characters by\npressing space.";
        String instructions4 = "\n\n-Move with the arrowkeys.";

        instructionItems = new String[]{instructions, instructions2, instructions3, instructions4};
    }

    @Override
    public void render(float delta) {
        String title = "This is how you play:";
        String pressEnter = "Press enter to begin the game";
        String pressBack = "Press backspace to go back";

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        titleFont.setColor(Color.BLACK);

        titleFont.draw(batch, title, 30, 500);

        for(int i = 0; i < instructionItems.length; i++){
            float rowDistance = 60;
            instructionFont.setColor(Color.BLACK);
            instructionFont.draw(batch, instructionItems[i], 30, 400 - rowDistance * i);
        }

        pressBackFont.setColor(Color.PINK);
        pressBackFont.draw(batch, pressBack, 30, 50);

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
