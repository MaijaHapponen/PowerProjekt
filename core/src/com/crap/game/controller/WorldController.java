package com.crap.game.controller;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.crap.game.model.Game;
import com.crap.game.model.Position;
import com.crap.game.view.GameView;

import static com.crap.game.model.Game.Worlds.*;

/**
 * Created by andrea on 2016-04-28.
 */
public class WorldController {

    private Game model;
    private PlayerController playerController;
    private CharacterController characterController;
    private GameView view;

    /*
    Float x = (Float) playerController.newWorldObject.getProperties().get("x");
    Float y = (Float) playerController.newWorldObject.getProperties().get("y");
    Float width = (Float) playerController.newWorldObject.getProperties().get("width");
    Float height = (Float) playerController.newWorldObject.getProperties().get("height");

  */
    private int tempCollisionlayerwidth = 50;

    private float zaloonEntryX = 125;
    private float zaloonEntryY = 15;

    private float hubbenEntryX = 100;
    private float hubbenEntryY = 50;

    private boolean isEntrance;
    private Position entrancePosition;
    private Game.Worlds previousRoom;


    public WorldController(Game game, PlayerController controller, CharacterController characterController, GameView view) {
        this.playerController = controller;
        this.characterController = characterController;
        this.model = game;
        this.view = view;

        this.isEntrance = false;
        this.entrancePosition = new Position(0,0);
    }

    public void setWorld(Game.Worlds worlds){

        float x = playerController.getPlayerPositionX();
        float y = playerController.getPlayerPositionY();

        switch (worlds) {

            case HORSAL:
                enterHorsal(x,y);
                setExit();
                view.setWorld(new TmxMapLoader().load("maps/horsalmaskin.tmx"));
                playerController.updateCollisionController();
                setPreviousRoom(HORSAL);
                break;

            case EDIT:
                enterEdit(x,y);
                setExit();
                view.setWorld(new TmxMapLoader().load("maps/hubbeneditsand.tmx"));
                playerController.updateCollisionController();
                setPreviousRoom(EDIT);
                characterController.updateCollisionController();
                break;

            case HUBBEN:
                setEntrance(x,y);
                enterHubben();
                view.setWorld(new TmxMapLoader().load("maps/hubbek.tmx"));
                playerController.updateCollisionController();
                setPreviousRoom(HUBBEN);
                characterController.updateCollisionController();
                break;

            case ZALOONEN:
                setEntrance(x,y);
                enterZaloonen();
                view.setWorld(new TmxMapLoader().load("maps/zaloonen.tmx"));
                playerController.updateCollisionController();
                setPreviousRoom(ZALOONEN);
                characterController.updateCollisionController();
                break;

            default:

                System.out.println("Ohoh! Something went wrong");
                break;
        }
    }

    public void enterHorsal(float x, float y){

        if(previousRoom == ZALOONEN){
            model.player.setPosition(entrancePosition.getX(), entrancePosition.getY());
        }

        if(x > view.getWorldWidth() - tempCollisionlayerwidth) {
            model.player.setPosition(tempCollisionlayerwidth, y);
        }

        else if(x < tempCollisionlayerwidth){
            model.player.setPosition(view.getWorldWidth()+tempCollisionlayerwidth, y);
        }
    }

    public void enterEdit(float x, float y){

        if(previousRoom == HUBBEN){
            model.player.setPosition(entrancePosition.getX(), entrancePosition.getY());
        }

        else if(x < tempCollisionlayerwidth) {
            model.player.setPosition(view.getWorldWidth()-tempCollisionlayerwidth, y);
        }

        else if (x > view.getWorldWidth() - tempCollisionlayerwidth){
            model.player.setPosition(view.getWorldWidth()+tempCollisionlayerwidth, y);
        }

    }

    public void enterHubben(){
        model.player.setPosition(hubbenEntryX,hubbenEntryY);
    }

    public void enterZaloonen(){
        model.player.setPosition(zaloonEntryX,zaloonEntryY);
    }

    public void setEntrance(float x, float y){
        entrancePosition.setPosition(x,y);
        isEntrance = true;
    }

    public void setExit(){
        isEntrance = false;
    }

    public void setPreviousRoom(Game.Worlds lastRoom) {
        this.previousRoom = lastRoom;
    }

    public PlayerController getPlayerController(){
        return this.playerController;
    }
}
