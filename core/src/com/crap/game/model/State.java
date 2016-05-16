package com.crap.game.model;

/**
 * Created by Maija on 2016-05-16.
 */
public class State {
    public enum GameStates {STARTMENU, PLAY, INTERACT, GAMEOVER}
    public  Game game;

    public void update(GameStates state){
        switch (state) {
            case STARTMENU:
                //updateStart();
                break;
            case PLAY:
                //updatePlay();
                break;
            case INTERACT:
                //updateInteract();
                break;
            case GAMEOVER:
                //gameOver = true;
                //updateGameOver();
                break;
        }
    }
}
