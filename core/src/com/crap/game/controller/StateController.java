package com.crap.game.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.crap.game.model.State;
import com.crap.game.view.*;

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

    public StateController(Game g) {
        this.game = g;
        this.world = new com.crap.game.model.Game();
        updateState(State.GameStates.STARTMENU);
    }

    public static void updateState(State.GameStates state) {

        switch (state) {

            case STARTMENU:
                MenuView menu = new MenuView(false);
                new MenuController(menu);
                game.setScreen(menu);
                break;

            case PLAY:
                if (!paused) initPlay();
                else unPauseGame();
                game.setScreen(worldView);
                break;

            case INTERACT:
                paused = true;
                setGameMode(false);

                if(controller.getPlayerController().isInteractionWithMascot()) {
                    InteractMascotView interactMascotView = new InteractMascotView(
                            controller.getPlayerController().getInteractionController().getInteractingCharacter());
                    new InteractMascotController(interactMascotView, controller);
                    game.setScreen(interactMascotView);
                }

                else if(controller.getPlayerController().isInteractionWithHuman()) {
                     InteractHumanView interactHumanView = new InteractHumanView(
                             controller.getPlayerController().getInteractionController().getInteractingCharacter());
                     new InteractHumanController(interactHumanView, controller);
                     game.setScreen(interactHumanView);
                 }

                break;

            case GAMEOVER:
                MenuView gameOver = new MenuView(true);
                new MenuController(gameOver);
                game.setScreen(gameOver);
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
