package com.crap.game.controller;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.crap.game.model.*;
import com.crap.game.model.Character;
import com.crap.game.view.GameView;

import java.util.Iterator;

/**
 * Created by andrea on 2016-05-11.
 */
public class InteractionController {
    private Interaction interactionModel;
    private GameView gameView;


    public InteractionController(GameView view){
        this.gameView = view;
        this.interactionModel = new Interaction(gameView.getPlayerView().getSprite().getWidth(),
                gameView.getPlayerView().getSprite().getHeight());

    }


    public boolean isInteractionWithHuman(float x, float y) {
        for (int i = 0; i < gameView.getHumansList().size(); i++) {
             interactionModel.setCharacter(gameView.getHumansList().get(i).getCharacter());

            if(interactionModel.isInteraction(x,y)) return true;
        }
        return false;
    }

    public boolean isInteractionWithMascot(float x, float y){
        for(int i=0; i< gameView.getMascotsList().size(); i++){
            interactionModel.setCharacter(gameView.getMascotsList().get(i).getCharacter());

            if(interactionModel.isInteraction(x,y)) return true;

        }

        return false;
    }

}
