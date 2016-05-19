package com.crap.game.model;

import com.crap.game.controller.HowToPlayController;
import com.crap.game.controller.MenuController;
import com.crap.game.view.*;

/**
 * Created by Maija on 2016-05-16.
 */
public class State {
    public enum GameStates {STARTMENU, PLAY, INTERACT, GAMEOVER, HOWTOPLAY}

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
                game.initPlay();
                game.setScreen(game.main.getWorldView());
                break;
            case INTERACT:
                game.setScreen(new InteractView());
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
