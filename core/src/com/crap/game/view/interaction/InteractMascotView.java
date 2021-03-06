package com.crap.game.view.interaction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.*;

import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.crap.game.model.character.Character;
import com.crap.game.model.character.mascotinteraction.InteractMascot;
import com.crap.game.model.character.Mascot;
import com.crap.game.model.information.TextForInteraction;

import java.util.List;

public class InteractMascotView extends ScreenAdapter {

    private SpriteBatch batch;

    private Character interactionCharacter;
    private InteractMascot interactMascot;

    private String question;
    private List<String> alternatives;

    private BitmapFont titleFont;
    private BitmapFont font;

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

        parameter.size= TextForInteraction.instructionFontSize;
        titleFont = generator.generateFont(parameter);

        parameter.size=TextForInteraction.informationFontSize;
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
            titleFont.draw(batch, question, TextForInteraction.titlePlacementX, TextForInteraction.titlePlacementY);
            for(int i = 0; i < alternatives.size(); i++) {

                if(interactMascot.getCurrentStringNbr() == i) {
                    font.setColor(Color.PINK);
                }

                else{
                    font.setColor(Color.BLACK);
                }

                font.draw(batch, alternatives.get(i), TextForInteraction.alternativesPlacementX,
                        TextForInteraction.alternativesPlacementY - TextForInteraction.spaceBetweenAlternatives/2 * i);
            }
        }

        else if(((Mascot)interactionCharacter).isCaught()) {

            font.setColor(Color.BLACK);
            font.draw(batch, TextForInteraction.rightAnswer, TextForInteraction.alternativesPlacementX,
                    TextForInteraction.onlyInformationY);
            font.draw(batch, TextForInteraction.returnToGame, TextForInteraction.alternativesPlacementX,
                    TextForInteraction.returnPlacementY);
            interactMascot.updateMascotCaught();
        }

        else{
            font.setColor(Color.BLACK);
            font.draw(batch, TextForInteraction.wrongAnswer, TextForInteraction.alternativesPlacementX,
                    TextForInteraction.onlyInformationY);
            font.draw(batch, TextForInteraction.returnToGame, TextForInteraction.alternativesPlacementX,
                    TextForInteraction.returnPlacementY);
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
