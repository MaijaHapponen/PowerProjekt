package com.crap.game.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.crap.game.model.State;
import com.crap.game.view.GameView;
import com.crap.game.view.HowToPlayView;
import com.crap.game.view.InteractView;
import com.crap.game.view.MenuView;

/**
 * Created by Maija on 2016-05-19.
 */
public class StateController {
    private State.GameStates currentState;

    public static GameView worldView;
    public static GameController controller;
    public static com.crap.game.model.Game world;
    public static boolean gameMode = false;

    //Game-class from libGDX, not our model
    public static Game game;
    public static boolean paused;

    public StateController(Game g){
        this.game = g;
        world = new com.crap.game.model.Game();
        updateState(State.GameStates.STARTMENU);
    }

    public static void updateState(State.GameStates state) {
        switch (state) {
            case STARTMENU:
                MenuView menu = new MenuView();
                new MenuController(menu);
                game.setScreen(menu);
                break;
            case PLAY:
                if(!paused) initPlay();
                else unPauseGame();
                game.setScreen(worldView);
                break;
            case INTERACT:
                paused = true;
                setGameMode(false);
                InteractView interactView = new InteractView();
                new InteractController(interactView, controller);
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

    public static void playMode(){
        Gdx.input.setInputProcessor(controller);
        gameMode = true;
    }

    public static void initPlay(){
        worldView = new GameView(world);
        controller = new GameController(worldView, world);
        gameMode = true;
    }

    public static void unPauseGame(){
        playMode();
    }
    public static void setGameMode(boolean b){
        gameMode = b;
    }

    public boolean getGameMode(){
        return gameMode;
    }
    public GameController getController(){
        return controller;
    }


}
