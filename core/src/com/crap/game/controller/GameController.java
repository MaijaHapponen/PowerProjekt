package com.crap.game.controller;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.crap.game.model.*;
import com.crap.game.model.Game;
import com.crap.game.view.GameView;

import static com.crap.game.model.Game.Worlds.*;

/**
 * Created by Lisa on 18/04/16.
 */
public class GameController extends InputAdapter {

    private WorldController worldController;
    private GameView view;
    private Game model;
    private OrthographicCamera camera;
    private PlayerController playerController;
    private int keyCode;
    private CharacterController characterController;

    public GameController(GameView view, Game game){

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

        this.view = view;
        this.model = game;

        this.view.setPlayer(this.model.player);
        this.view.setCamera(this.camera);

        this.view.setHumans(this.model.humans);
        this.view.setMascots(this.model.mascots);

        this.playerController = new PlayerController(this.view.getPlayerView(), this.view);
        this.characterController = new CharacterController(view);
        this.worldController = new WorldController(this.model, this.playerController, this.characterController, this.view);

        worldController.setWorld(HORSAL);
        model.player.setPosition(250, 250);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        if(view.isInteraction() && keycode == Input.Keys.SPACE){
            StateController.updateState(State.GameStates.INTERACT);
        }
        this.keyCode=keycode;
        view.render();
        return true;
    }

    public void movePlayer(int keycode){
        this.keyCode = keycode;
//        System.out.println(view.getWorldWidth());
//        System.out.println(playerController.getPlayerPositionX() + "+" + playerController.getPlayerPositionY());
        playerController.movePlayer(keyCode);
    }

    public void enterNewWorld() {
        if(playerController.getNewWorldName().equals("hubbeneditsand")) {
            view.setLabel("hörsalsvägen");

            worldController.setWorld(EDIT);

        }else if(playerController.getNewWorldName().equals("horsalmaskin")){
            view.setLabel("hörsalsvägen");

            worldController.setWorld(HORSAL);

        }else if(playerController.getNewWorldName().equals("hubben")){
            view.setLabel("hubben");

            worldController.setWorld(HUBBEN);

        }else if(playerController.getNewWorldName().equals("zaloonen")){
            view.setLabel("zaloonen");

            worldController.setWorld(ZALOONEN);

        }
    }

    public CharacterController getCharacterController(){
        return this.characterController;
    }

    public PlayerController getPlayerController(){
        return this.playerController;
    }

    public void updateIfNewWorld() {
        if(playerController.isNewWorld()) {
            enterNewWorld();
            view.setNewWorld(true);
            view.create();
        }
    }

    public void updateIfInteraction(){
        if(playerController.isInteractionWithMascot() || playerController.isInteractionWithHuman()){
            view.setInteraction(true);
        }else{
            view.setInteraction(false);
        }
    }
    
    public void render() {
        updateIfNewWorld();
        updateIfInteraction();

        if(Gdx.input.isKeyPressed(keyCode)) {
            movePlayer(keyCode);
        }
        else {
            playerController.stopWalkingAnimation(keyCode);
        }

        characterController.walkAway(playerController.getInteractionController().getInteractingCharacter(),
                playerController.getInteractionController().getInteractingCharacterView());
    }
    public void mascotCaught(Mascot caughtMascot){
        model.mascotCaught(caughtMascot);
    }
}

