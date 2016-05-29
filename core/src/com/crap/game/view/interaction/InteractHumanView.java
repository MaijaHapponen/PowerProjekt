package com.crap.game.view.interaction;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.crap.game.model.character.Character;
import com.crap.game.model.character.Human;
import com.crap.game.model.character.humaninteraction.InteractHuman;
import com.crap.game.model.information.TextForInteraction;

/**
 * Created by rebeccafinne on 16-05-23.
 */
public class InteractHumanView extends ScreenAdapter {

    private SpriteBatch batch;

    private BitmapFont title;
    private BitmapFont font;
    private FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Candy Shop.ttf"));
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

    private Character interactionCharacter;

    private String [] options;
    private InteractHuman interactHuman;


    public InteractHumanView(Character interactionCharacter){
        this.interactionCharacter = interactionCharacter;
        batch = new SpriteBatch();
        create();
    }

    public void create(){

        parameter.size = TextForInteraction.instructionFontSize;
        title = generator.generateFont(parameter);
        title.setColor(Color.BLACK);

        parameter.size = TextForInteraction.informationFontSize;
        font = generator.generateFont(parameter);

        generator.dispose();

        options = new String[]{TextForInteraction.talkAboutProgramme, TextForInteraction.whereIsMascot,
                TextForInteraction.cancel};
        interactHuman = new InteractHuman(options, TextForInteraction.talkAboutProgramme);
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
            title.draw(batch, informationGreeting, TextForInteraction.titlePlacementX, TextForInteraction.humanGreetingY);
            for (int i = 0; i < options.length; i++) {
                if (interactHuman.getCurrentStringNbr() == i) {
                    font.setColor(Color.PINK);
                } else {
                    font.setColor(Color.BLACK);
                }
                font.draw(batch, options[i], TextForInteraction.alternativesPlacementX,
                        TextForInteraction.alternativesPlacementY - TextForInteraction.spaceBetweenAlternatives * i);
            }
        }
        else if(interactHuman.getIsProgramme()) {
            font.setColor(Color.BLACK);
            font.draw(batch, informationProgramme, TextForInteraction.alternativesPlacementX,
                    TextForInteraction.onlyInformationY);
            font.draw(batch, TextForInteraction.returnToGame, TextForInteraction.alternativesPlacementX,
                    TextForInteraction.returnPlacementY);
        }
        else if(interactHuman.getIsMascot()){
            font.setColor(Color.BLACK);
            font.draw(batch, informationLocation, TextForInteraction.alternativesPlacementX,
                    TextForInteraction.onlyInformationY);
            font.draw(batch, TextForInteraction.returnToGame, TextForInteraction.alternativesPlacementX,
                    TextForInteraction.returnPlacementY);
        }
        batch.end();
    }
    public InteractHuman getInteractHuman(){
        return this.interactHuman;
    }

}
