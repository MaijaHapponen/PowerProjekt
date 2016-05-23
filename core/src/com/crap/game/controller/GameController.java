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
public class GameController extends InputAdapter implements ApplicationListener {

    private WorldController worldController;
    private GameView view;
    private Game model;
    private OrthographicCamera camera;
    private PlayerController playerController;
    private int keyCode;
    private Position entrancePosition;
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

        // this.collisionController = new CollisionController(view.getWorld();
        this.playerController = new PlayerController(this.view.getPlayerView(), this.view);
        this.worldController = new WorldController(this.model, this.playerController, this.view);
        this.characterController = new CharacterController(view, model.getHumans(), model.getMascots(), view.getHumansList(),
                view.getMascotsList());
//TODO ********
//        this.humans = game.getHumans();
//        this.mascots = game.getMascots();
//
//        for(int i=0; i<mascots.size(); i++){
//            mascotControllers.add(new CharacterController(mascots.get(i)));
//        }
//
//        for(int i=0; i<humans.size(); i++){
//            humanControllers.add(new CharacterController(humans.get(i)));
//        }

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
        playerController.movePlayer(keyCode);
    }

    public void enterNewWorld() {
        if(playerController.getNewWorldName().equals("hubbeneditsand")) {
            worldController.setWorld(EDIT);
        }else if(playerController.getNewWorldName().equals("horsalmaskin")){
            worldController.setWorld(HORSAL);
        }else if(playerController.getNewWorldName().equals("hubben")){
            worldController.setWorld(HUBBEN);
        }else if(playerController.getNewWorldName().equals("zaloonen")){
            worldController.setWorld(ZALOONEN);
        }

    }

    public CharacterController getCharacterController(){
        return this.characterController;
    }

    public void updateIfNewWorld() {
        if(playerController.isNewWorld()) {
            enterNewWorld();
        }

    }

    public void updateIfInteraction(){
        if(playerController.isInteractionWithMascot() || playerController.isInteractionWithHuman()){
            view.setInteraction(true);
        }else{
            view.setInteraction(false);
        }
    }

    public PlayerController getPlayerController(){
        return this.playerController;
    }

    @Override
    public void render() {
        updateIfNewWorld();
        updateIfInteraction();

        if(Gdx.input.isKeyPressed(keyCode)) {
            movePlayer(keyCode);
        }
        else {
            playerController.stopWalkingAnimation(keyCode);
        }

        characterController.walkAway();
    }

    @Override
    public void create() {}

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {}
}

