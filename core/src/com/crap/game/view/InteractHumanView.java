package com.crap.game.view;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.crap.game.model.Character;
import com.crap.game.model.Human;
import com.crap.game.model.InteractHuman;

/**
 * Created by rebeccafinne on 16-05-23.
 */
public class InteractHumanView extends ScreenAdapter {

    private SpriteBatch batch;

    private BitmapFont title;
    private BitmapFont font;
    private BitmapFont information;
    private FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Candy Shop.ttf"));
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

    private String talkAboutProgramme = "Ask about programme";
    private String whereIsMascot = "Ask where mascot could be";
    //TODO:put into constants
    private String back = "Press BACKSPACE to return to game";
    private String exit = "Exit";

    private Character interactionCharacter;

    private String [] options;
    private InteractHuman interactHuman;


    public InteractHumanView(Character interactionCharacter){
        this.interactionCharacter = interactionCharacter;
        batch = new SpriteBatch();
        create();
    }

    public void create(){

        parameter.size = 12;
        title = generator.generateFont(parameter);
        title.setColor(Color.BLACK);

        parameter.size = 12;
        font = generator.generateFont(parameter);

        parameter.size = 13;
        information = generator.generateFont(parameter);

        generator.dispose();

        options = new String[]{talkAboutProgramme, whereIsMascot, exit};
        interactHuman = new InteractHuman(options, talkAboutProgramme);
    }

    @Override
    public void render(float delta) {

        String informationProgramme = ((Human)interactionCharacter).getInformationAboutProgramme();
        String informationLocation = ((Human)interactionCharacter).getInformationAboutLocation();
        String informationGreeting = ((Human)interactionCharacter).getInformationAboutGreeting();

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        if(!interactHuman.getIsProgramme() && !interactHuman.getIsMascot()) {

            title.draw(batch, informationGreeting, 30, 400);

            for (int i = 0; i < options.length; i++) {
                if (interactHuman.getCurrentStringNbr() == i) {
                    font.setColor(Color.PINK);

                } else {
                    font.setColor(Color.BLACK);
                }
                font.draw(batch, options[i], 60, 250 - 70 * i);
            }
        }


        else if(interactHuman.getIsProgramme()) {
            font.setColor(Color.BLACK);
            font.draw(batch, informationProgramme, 60, 300);
            font.draw(batch, back, 60, 150);
        }

        else if(interactHuman.getIsMascot()){
            font.setColor(Color.BLACK);
            font.draw(batch, informationLocation, 60, 300);
            font.draw(batch, back, 60, 150);
        }

        batch.end();
    }

    public String getTalkAboutProgramme(){
        return this.talkAboutProgramme;
    }

    public String getWhereIsMascot(){
        return this.whereIsMascot;
    }

    public String getExit(){
        return this.exit;
    }

    public InteractHuman getInteractHuman(){
        return this.interactHuman;
    }

}
