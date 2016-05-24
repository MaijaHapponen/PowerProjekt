package com.crap.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.*;

import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.crap.game.model.*;
import com.crap.game.model.Character;
import com.crap.game.model.InteractMascot;


/**
 * Created by Maija on 2016-05-11.
 */
public class InteractMascotView extends ScreenAdapter {

    private SpriteBatch batch;

    private Character interactionCharacter;

    private boolean hasAnswered;

    private String back = "Press BACK SPACE to return to game";
    private String questionLabel;
    private String answerLabel1;
    private String answerLabel2;
    private String answerLabel3;
    private  String answerLabel4;

    private InteractMascot interactMascot;


    BitmapFont titleFont;
    BitmapFont font;

    FreeTypeFontGenerator generator = new FreeTypeFontGenerator( Gdx.files.internal("fonts/Candy Shop.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

    String[] answers;


    public InteractMascotView(Character interactionCharacter){
        this.interactionCharacter = interactionCharacter;
        this.batch = new SpriteBatch();

        create();
    }

    public void create(){

        String question = getQuestion(interactionCharacter);
        java.util.List<String> alternatives = getAnswers(interactionCharacter);


        FreeTypeFontGenerator generator = new FreeTypeFontGenerator( Gdx.files.internal("fonts/Candy Shop.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size=20;
        titleFont = generator.generateFont(parameter);

        parameter.size=10;
        font= generator.generateFont(parameter);
        generator.dispose();

        questionLabel = (question);
        answerLabel1 = (alternatives.get(0));
        answerLabel2 = (alternatives.get(1));
        answerLabel3 = (alternatives.get(2));
        answerLabel4 = (alternatives.get(2));


        answers = new String[]{answerLabel1, answerLabel2, answerLabel3, answerLabel4};
        interactMascot = new InteractMascot(answers, questionLabel);
    }

    public String getQuestion(Character interactionCharacter){

        if(interactionCharacter instanceof Mascot){
            return ((Mascot) interactionCharacter).getQuestion().getQuestion();
        }

        return null;
    }

    public java.util.List<String> getAnswers(Character interactionCharacter) {

        if (interactionCharacter instanceof Mascot) {
            return ((Mascot) interactionCharacter).getQuestion().getAlternatives();
        }

        return null;
    }

    public InteractMascot getInteractModel(){
        return this.interactMascot;
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        if(!hasAnswered) {

            titleFont.setColor(Color.BLACK);
            titleFont.draw(batch, questionLabel, 15, 450);
            for(int i = 0; i < answers.length; i++) {

                
                if(interactMascot.getCurrentStringNbr() == i) {
                    font.setColor(Color.PINK);
                }

                else{
                    font.setColor(Color.BLACK);
                }
                font.draw(batch, answers[i], 200, 250 - 30 * i);



            }
        }

        else if(((Mascot)interactionCharacter).isCaught()) {

            font.setColor(Color.BLACK);
            font.draw(batch, "You are right!", 60, 300);
            font.draw(batch, back, 60, 250);
            interactMascot.updateMascotCaught();

        }

        else{
            font.setColor(Color.BLACK);
            font.draw(batch, "You were wrong :(", 60, 300);
            font.draw(batch, back, 60, 250);

        }
        batch.end();

    }

    public void setHasAnswered(){
        this.hasAnswered = true;
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
