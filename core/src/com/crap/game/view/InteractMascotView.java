package com.crap.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.*;

import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.crap.game.model.*;
import com.crap.game.model.Character;
import com.crap.game.model.InteractMascot;

import java.util.List;

/**
 * Created by Maija on 2016-05-11.
 */
public class InteractMascotView extends ScreenAdapter {

    private SpriteBatch batch;

    private Character interactionCharacter;
    private InteractMascot interactMascot;

    private String question;
    private List<String> alternatives;

    BitmapFont titleFont;
    BitmapFont font;

    FreeTypeFontGenerator generator = new FreeTypeFontGenerator( Gdx.files.internal("fonts/Candy Shop.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

    public InteractMascotView(Character interactionCharacter){
        this.interactionCharacter = interactionCharacter;
        this.batch = new SpriteBatch();

        this.question = ((Mascot)interactionCharacter).getQuestion().getQuestion();
        this.alternatives = ((Mascot)interactionCharacter).getQuestion().getAlternatives();

        create();
    }

    public void create(){

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator( Gdx.files.internal("fonts/Candy Shop.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size=20;
        titleFont = generator.generateFont(parameter);

        parameter.size=10;
        font= generator.generateFont(parameter);
        generator.dispose();

        interactMascot = new InteractMascot(alternatives);
    }

    public InteractMascot getInteractModel(){
        return this.interactMascot;
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        if(!interactMascot.getHasAnswered()) {

            titleFont.setColor(Color.BLACK);
            titleFont.draw(batch, question, 15, 450);
            for(int i = 0; i < alternatives.size(); i++) {

                if(interactMascot.getCurrentStringNbr() == i) {
                    font.setColor(Color.PINK);
                }

                else{
                    font.setColor(Color.BLACK);
                }

                font.draw(batch, alternatives.get(i), 200, 250 - 30 * i);
            }
        }

        else if(((Mascot)interactionCharacter).isCaught()) {

            font.setColor(Color.BLACK);
            font.draw(batch, interactMascot.getRight(), 60, 300);
            font.draw(batch, interactMascot.getBack(), 60, 250);
            interactMascot.updateMascotCaught();
        }

        else{
            font.setColor(Color.BLACK);
            font.draw(batch, interactMascot.getWrong(), 60, 300);
            font.draw(batch, interactMascot.getBack(), 60, 250);
        }

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void dispose(){
        batch.dispose();
        titleFont.dispose();
        font.dispose();
    }
}
