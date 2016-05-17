package com.crap.game.model;

import com.crap.game.controller.MenuController;
import com.crap.game.view.GameView;
import com.crap.game.view.HowToPlayView;
import com.crap.game.view.InteractionView;
import com.crap.game.view.MenuView;

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
                game.setScreen(new InteractionView());
                break;
            case GAMEOVER:
                //this.view.main.setScreen(new GameOverView());
                //gameOver = true;
                break;
            case HOWTOPLAY:
                HowToPlayView howToPlayView = new HowToPlayView();
                game.setScreen(howToPlayView);
                break;

        }
    }

}
