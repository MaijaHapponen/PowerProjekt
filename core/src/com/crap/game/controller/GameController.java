package com.crap.game.controller;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.crap.game.model.Game;
import com.crap.game.model.State;
import com.crap.game.view.GameView;
import com.crap.game.view.InteractionView;

import static com.crap.game.model.Game.*;
import static com.crap.game.model.Game.Worlds.EDIT;
import static com.crap.game.model.Game.Worlds.HORSAL;

/**
 * Created by Lisa on 18/04/16.
 */
public class GameController extends InputAdapter implements ApplicationListener {

    private GameView view;
    private Game model;
    private OrthographicCamera camera;
    private PlayerController playerController;
    private int keyCode;

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
        setWorld(HORSAL);

        //State.updateState(State.GameStates.STARTMENU);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        this.keyCode=keycode;
        if(playerController.collisionController.isNewWorld(playerController.getPlayerPositionX()+
                playerController.player.getCurrentSpeed(), playerController.getPlayerPositionY())){
            enterNewWorld();
        }
        else if(playerController.interactionController.isInteractionWithMascot(model.getPlayer().getPosition().getX(),
                            model.getPlayer().getPosition().getY()) || playerController.interactionController.
                    isInteractionWithMascot(model.getPlayer().getPosition().getX(),model.getPlayer().getPosition().getY())){
            //this.state = INTERACT;
        }
        view.render();
        return true;
    }

    public void movePlayer(int keycode){
        this.keyCode = keycode;
        playerController.movePlayer(keyCode);
    }

    public void setWorld(Worlds worlds){
        switch (worlds) {
            case HORSAL:
                view.setWorld(new TmxMapLoader().load("maps/horsalmaskin.tmx"));
                playerController.collisionController = new CollisionController(view.getWorld());
                model.player.setPosition(250,250); //TODO: Change value to correct location
                break;

            case EDIT:
                view.setWorld(new TmxMapLoader().load("maps/hubbeneditsand.tmx"));
                playerController.collisionController = new CollisionController(view.getWorld());
                model.player.setPosition(250,250); //TODO: Change value to correct location
                break;

            case PARKING:
                view.setWorld(new TmxMapLoader().load("maps/parkingtemplate.tmx"));
                playerController.collisionController = new CollisionController(view.getWorld());
                model.player.setPosition(1,1); //TODO: Change value to correct location
                break;
            case HUBBEN:
                view.setWorld(new TmxMapLoader().load("maps/hubbek.tmx"));
                model.player.setPosition(20, 20);
                break;
            default:
                System.out.println("Ohoh! Something went wrong");
                break;
        }
    }

    public void enterNewWorld() {
        setWorld(EDIT);
    }

    @Override
    public void render() {
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

