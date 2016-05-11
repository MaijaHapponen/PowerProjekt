package com.crap.game.controller;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.crap.game.model.*;
import com.crap.game.model.Character;
import com.crap.game.view.GameView;

import java.util.Iterator;

/**
 * Created by andrea on 2016-05-11.
 */
public class InteractionController {

    private GameView gameView;
    private float playerWidth;
    private float playerHeight;

    private Sprite character;

    public InteractionController(GameView view){
        this.gameView = view;
        this.playerWidth = gameView.getPlayerView().getSprite().getWidth();
        this.playerHeight = gameView.getPlayerView().getSprite().getHeight();
    }


    public boolean isInteractionWithHuman(float x, float y) {
        for (int i = 0; i < gameView.getHumansList().size(); i++) {
            character = gameView.getHumansList().get(i).getSprite();
            if(checkEveryPositionForInteraction(x,y)){
                return true;
            }
        }
        return false;
    }

    public boolean isInteractionWithMascot(float x, float y){
        for(int i=0; i< gameView.getMascotsList().size(); i++){
            character = gameView.getMascotsList().get(i).getSprite();
            if(checkEveryPositionForInteraction(x,y)){
                return true;
            }
        }

        return false;
    }
    public boolean checkEveryPositionForInteraction(float x, float y) {
        return checkIfInteraction(x,y)||checkIfInteraction(x+playerWidth,y)||
                checkIfInteraction(x+playerWidth,y+playerHeight)||checkIfInteraction(x,y+playerHeight)
                ||checkIfInteraction(x,y+playerHeight/2)||checkIfInteraction(x+playerWidth,y+ playerHeight/2);

    }

    public boolean checkIfInteraction( float playerPositionX, float playerPositionY){
        Float x = character.getX();
        Float y = character.getY();
        Float width = character.getWidth();
        Float height = character.getHeight();

        return(playerPositionX > x && playerPositionX < x+width)
                && (playerPositionY>y && playerPositionY<y+height) ;

    }
}
