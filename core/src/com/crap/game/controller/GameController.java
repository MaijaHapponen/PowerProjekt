package com.crap.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.crap.game.model.Constants;
import com.crap.game.model.Game;
import com.crap.game.model.GameStates;
import com.crap.game.model.Mascot;
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
        this.view.getPlayerView().setCamera(this.camera);

        this.view.setHumans(this.model.humans);
        this.view.setMascots(this.model.mascots);

        this.playerController = new PlayerController(this.view.getPlayerView(), this.view);
        this.characterController = new CharacterController(view);
        this.worldController = new WorldController(this.model, this.playerController, this.characterController, this.view);

        worldController.setWorld(HORSAL);
        model.player.setPosition(Constants.START_X_COORDINATE_PLAYER, Constants.START_Y_COORDINATE_PLAYER);
        playerController.updateCamera();

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        if(view.isInteraction() && keycode == Input.Keys.SPACE){
            StateController.updateState(GameStates.INTERACT);
        }
        this.keyCode=keycode;
        return true;
    }

    public void enterNewWorld() {
        if(playerController.getCollisionController().getNewWorldName().equals("hubbeneditsand")) {
            view.setLabel("hörsalsvägen");

            worldController.setWorld(EDIT);

        }else if(playerController.getCollisionController().getNewWorldName().equals("horsalmaskin")){
            view.setLabel("hörsalsvägen");

            worldController.setWorld(HORSAL);

        }else if(playerController.getCollisionController().getNewWorldName().equals("hubben")){
            view.setLabel("hubben");

            worldController.setWorld(HUBBEN);

        }else if(playerController.getCollisionController().getNewWorldName().equals("zaloonen")){
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
            model.setNewWorld(true);
            view.createWelcome();
        }
    }

    public void updateIfInteraction(){
        if(playerController.isInteractionWithMascot() || playerController.isInteractionWithHuman()){
            view.setInteraction(true);
        }else{
            view.setInteraction(false);
        }
    }

    public void updateIfGameOver(){
        if(model.isGameOver()){
            StateController.updateState(GameStates.GAMEOVER);
        }
    }

    public void render() {
        updateIfGameOver();

        updateIfNewWorld();
        updateIfInteraction();

        if(Gdx.input.isKeyPressed(keyCode)) {
            playerController.movePlayer(keyCode);
        }
        else {
            playerController.stopWalkingAnimation(keyCode);
        }

        characterController.walkAway(playerController.getInteractionController().getInteractingCharacter(),
                playerController.getInteractionController().getInteractingCharacterView());
    }

    //TODO: Move to model
    public void mascotCaught(Mascot caughtMascot){
        model.mascotCaught(caughtMascot);
    }
}

