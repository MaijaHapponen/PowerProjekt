package com.crap.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.crap.game.model.InteractHuman;

/**
 * Created by rebeccafinne on 16-05-23.
 */
public class InteractHumanView extends ScreenAdapter {

    SpriteBatch batch;
    BitmapFont title;
    BitmapFont font;
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Candy Shop.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    private String chooseOption = "Hello! What do you want to know more about?";
    private String talkAboutProgramme = "Ask about programme";
    private String whereIsMascot = "Ask where mascot could be";
    private String exit = "Exit";

    private String [] options;
    private InteractHuman interactHuman;
    public InteractHumanView(){

        batch = new SpriteBatch();
        create();
    }

    public void create(){

        parameter.size = 12;
        title = generator.generateFont(parameter);
        title.setColor(Color.BLACK);

        parameter.size = 12;
        font = generator.generateFont(parameter);

        generator.dispose();


        options = new String[]{talkAboutProgramme, whereIsMascot, exit};
        interactHuman = new InteractHuman(options, talkAboutProgramme);



    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        title.draw(batch, chooseOption, 30, 400);


        for(int i = 0; i < options.length; i++){
            if(interactHuman.getCurrentStringNbr() == i){
                font.setColor(Color.PINK);

            } else {
                font.setColor(Color.BLACK);
            }
            font.draw(batch, options[i], 60, 250 - 70*i);
        }


        batch.end();
    }

    public InteractHuman getInteractHuman(){
        return this.interactHuman;
    }
}
