package com.crap.game.model;

import com.crap.game.controller.*;
import com.crap.game.view.*;

/**
 * Created by Maija on 2016-05-16.
 */
public class State {
    public enum GameStates {STARTMENU, PLAY, INTERACT, GAMEOVER, HOWTOPLAY}

    public static boolean paused;
    public static Game game;
    public State(Game g){
        this.game = g;
    }

    public static void updateState(GameStates state) {
        switch (state) {
            //TODO: Move to controller-class? States can still be in this class though
            case STARTMENU:
                MenuView menu = new MenuView();
                new MenuController(menu);
                game.setScreen(menu);
                break;
            case PLAY:
                if(!paused) game.initPlay();
                game.setScreen(game.main.getWorldView());
                break;
            case INTERACT:
                paused = true;
                InteractView interactView = new InteractView();
                new InteractController(interactView);
                game.setScreen(interactView);
                break;
            case GAMEOVER:
                //this.view.main.setScreen(new GameOverView());
                //gameOver = true;
                break;
            case HOWTOPLAY:
                new HowToPlayController();
                game.setScreen(new HowToPlayView());
                break;

        }
    }

}
