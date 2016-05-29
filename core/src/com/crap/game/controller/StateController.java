package com.crap.game.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.crap.game.model.CRAP;
import com.crap.game.model.Constants;
import com.crap.game.model.GameStates;
import com.crap.game.view.*;

public class StateController {

    public static CRAPView worldView;
    public static CRAPController controller;
    public static CRAP world;
    public static boolean gameMode = false;

    public static Game game;
    public static boolean paused;

    public StateController(Game g) {
        this.game = g;
        Constants.SCREEN_WIDTH= Gdx.graphics.getWidth();
        Constants.SCREEN_HEIGHT = Gdx.graphics.getHeight();
        updateState(GameStates.STARTMENU);
    }

    public static void updateState(GameStates state) {
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
            case INTERACT: //Sets the view depending on interaction with human or mascot
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
                     new InteractHumanController(interactHumanView);
                     game.setScreen(interactHumanView);
                 }
                break;
            case GAMEOVER:
                paused = false;
                setGameMode(false);
                MenuView gameOver = new MenuView(true);
                new MenuController(gameOver);
                game.setScreen(gameOver);
                worldView.dispose();
                break;
            case HOWTOPLAY:
                new HowToPlayController();
                game.setScreen(new HowToPlayView());
                break;
        }
    }


    public static void playMode(){
        Gdx.input.setInputProcessor(controller);
        setGameMode(true);
    }

    public static void initPlay(){
        world = new CRAP();
        worldView = new CRAPView(world);
        controller = new CRAPController(worldView, world);
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

    public CRAPController getController(){
        return controller;
    }
}
