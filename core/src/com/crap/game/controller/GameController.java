package com.crap.game.controller;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.crap.game.model.Game;
import com.crap.game.model.Human;
import com.crap.game.model.Mascot;
import com.crap.game.model.State;
import com.crap.game.view.GameView;

import java.util.ArrayList;

import static com.crap.game.model.Game.*;
import static com.crap.game.model.Game.Worlds.*;

/**
 * Created by Lisa on 18/04/16.
 */
public class GameController extends InputAdapter implements ApplicationListener {

    private GameView view;
    private Game model;
    private OrthographicCamera camera;
    private PlayerController playerController;
    private int keyCode;
    private CollisionController collisionController;
    private CharacterController characterController;

//TODO    public static ArrayList<Human> humans = new ArrayList<Human>();
//    public static ArrayList<Mascot> mascots = new ArrayList<Mascot>();
//    public static ArrayList<CharacterController> humanControllers = new ArrayList<CharacterController>();
//    public static ArrayList<CharacterController> mascotControllers = new ArrayList<CharacterController>();

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

        // this.collisionController = new CollisionController(view.getWorld());
        this.playerController = new PlayerController(this.view.getPlayerView(), this.view);
        this.characterController = new CharacterController(model.getHumans(), model.getMascots(), view.getHumansList(),
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

        setWorld(HORSAL);
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

    public void setWorld(Worlds worlds){
        /*
        Float x = (Float) playerController.newWorldObject.getProperties().get("x");
        Float y = (Float) playerController.newWorldObject.getProperties().get("y");
        Float width = (Float) playerController.newWorldObject.getProperties().get("width");
        Float height = (Float) playerController.newWorldObject.getProperties().get("height");

      */
        int tempCollisionlayerwidth = 50;
        int zaloonExitX = 224;
        int zaloonExitY = 803;
        int horsalEntranceX = 350;
        int horsalEntranceY = 310;
        switch (worlds) {
            case HORSAL:
                if(playerController.getPlayerPositionY() < zaloonExitX && playerController.getPlayerPositionY() < zaloonExitY){
                    view.setWorld(new TmxMapLoader().load("maps/horsalmaskin.tmx"));
                    playerController.updateCollisionController();
                    model.player.setPosition(horsalEntranceX, horsalEntranceY);
                }
                else if(playerController.getPlayerPositionX() > view.getWorldWidth() -tempCollisionlayerwidth) {
                    if(playerController.getPlayerPositionY() > tempCollisionlayerwidth) {
                        view.setWorld(new TmxMapLoader().load("maps/horsalmaskin.tmx"));
                        playerController.updateCollisionController();
                        model.player.setPosition(tempCollisionlayerwidth, playerController.getPlayerPositionY());
                    }
                }
                else{
                    view.setWorld(new TmxMapLoader().load("maps/horsalmaskin.tmx"));
                    playerController.updateCollisionController();
                    model.player.setPosition(view.getWorldWidth()-tempCollisionlayerwidth, playerController.getPlayerPositionY());
                }
                break;

            case EDIT:
                if(playerController.getPlayerPositionX() < tempCollisionlayerwidth) {
                    view.setWorld(new TmxMapLoader().load("maps/hubbeneditsand.tmx"));
                    playerController.updateCollisionController();
                    model.player.setPosition(view.getWorldWidth()-tempCollisionlayerwidth, playerController.getPlayerPositionY());
                }
                else{
                    view.setWorld(new TmxMapLoader().load("maps/hubbeneditsand.tmx"));
                    playerController.updateCollisionController();
                    model.player.setPosition(view.getWorldWidth()+tempCollisionlayerwidth, playerController.getPlayerPositionY());
                }
                break;

            case PARKING:
                view.setWorld(new TmxMapLoader().load("maps/parkingtemplate.tmx"));
                playerController.updateCollisionController();
                model.player.setPosition(1,1); //TODO: Change value to correct location
                break;

            case HUBBEN:
                view.setWorld(new TmxMapLoader().load("maps/hubbek.tmx"));
                playerController.updateCollisionController();
                model.player.setPosition(1,1);
                break;

            case ZALOONEN:
                view.setWorld(new TmxMapLoader().load("maps/zaloonen.tmx"));
                playerController.updateCollisionController();
                model.player.setPosition(1,50);

            default:
                System.out.println("Ohoh! Something went wrong");
                break;
        }
    }

    public void enterNewWorld() {
        //TODO: make correct for all maps
        if(playerController.getNewWorldName().equals("hubbeneditsand")) {
            setWorld(EDIT);
        }else if(playerController.getNewWorldName().equals("horsalmaskin")){
            setWorld(HORSAL);
        }else if(playerController.getNewWorldName().equals("hubben")){
            setWorld(HUBBEN);
        }else if(playerController.getNewWorldName().equals("zaloonen")){
            setWorld(ZALOONEN);
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
        if(playerController.isInteractionWithMascot()){
            view.setInteraction(true);
        }else{
            view.setInteraction(false);
        }
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

