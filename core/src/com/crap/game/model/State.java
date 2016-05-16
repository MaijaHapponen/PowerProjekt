
package com.crap.game.model;

import com.crap.game.controller.MenuController;
import com.crap.game.view.GameView;
import com.crap.game.view.InteractionView;
import com.crap.game.view.MenuView;

/**
 * Created by Maija on 2016-05-16.
 */
public class State {
    public enum GameStates {STARTMENU, PLAY, INTERACT, GAMEOVER}
    public static Game game;
    public State(Game g, State.GameStates state){
        this.game = g;
        updateState(state);
    }

    public void updateState(GameStates state) {
        switch (state) {
            case STARTMENU:
                MenuView menu = new MenuView();
                new MenuController(menu);
                game.setScreen(menu);
                break;
            case PLAY:
                game.main.create();
                game.main.setScreen(game.main.getWorldView());
                break;
            case INTERACT:
                game.main.setScreen(new InteractionView());
                break;
            case GAMEOVER:
                //this.view.main.setScreen(new GameOverView());
                //gameOver = true;
                break;
        }
    }
}
