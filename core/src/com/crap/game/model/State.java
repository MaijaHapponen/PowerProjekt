package com.crap.game.model;

import com.crap.game.view.InteractionView;

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
    /*switch (state) {
        case STARTMENU:
            //this.view.main.setScreen(new MainInteraction());
            break;
        case PLAY:
            this.view.main.setScreen(this.view);
            break;
        case INTERACT:
            this.view.main.setScreen(new InteractionView(this.view.main));
            break;
        case GAMEOVER:
            //this.view.main.setScreen(new GameOverView());
            //gameOver = true;
            break;
    }*/
}
