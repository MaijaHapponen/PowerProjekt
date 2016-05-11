package com.crap.game.controller;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.crap.game.model.CollisionModel;
import com.crap.game.model.Player;
import com.crap.game.view.GameView;

import java.util.Iterator;

/**
 * Created by andrea on 2016-05-11.
 */
public class InteractionController {

    private GameView gameView;
    private float playerWidth;
    private float playerHeight;

    public InteractionController(GameView view){
        this.gameView = view;
        this.playerWidth = gameView.getPlayerView().getSprite().getWidth();
        this.playerHeight = gameView.getPlayerView().getSprite().getHeight();
    }

    public boolean isInteractionWithHuman(float playerPositionX, float playerPositionY) {
        for (int i = 0; i < gameView.getHumansList().size(); i++) {
            Float x = gameView.getHumansList().get(i).getSprite().getX();
            Float y = gameView.getHumansList().get(i).getSprite().getY();
            Float width = gameView.getHumansList().get(i).getSprite().getWidth();
            Float height = gameView.getHumansList().get(i).getSprite().getHeight();

            return (playerPositionX + playerWidth > x && playerPositionX < x)
                    && (playerPositionY + playerHeight> y && playerPositionY < y );
        }
        return false;
    }

    public boolean isInteractionWithMascot(float playerPositionX, float playerPositionY){
        for(int i=0; i< gameView.getMascotsList().size(); i++){
            Float x = gameView.getMascotsList().get(i).getSprite().getX();
            Float y = gameView.getMascotsList().get(i).getSprite().getY();
            Float width = gameView.getMascotsList().get(i).getSprite().getWidth();
            Float height = gameView.getMascotsList().get(i).getSprite().getHeight();

            return(playerPositionX > x && playerPositionX < x+width)
                    && (playerPositionY>y && playerPositionY<y+height) ;
        }
        return false;
    }
}
