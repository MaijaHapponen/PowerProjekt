package com.crap.game.controller;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.crap.game.model.Game;
import com.crap.game.model.Position;
import com.crap.game.view.GameView;
/**
 * Created by andrea on 2016-04-28.
 */
public class WorldController {

    private Game model;
    private PlayerController playerController;
    private GameView view;

    /*
    Float x = (Float) playerController.newWorldObject.getProperties().get("x");
    Float y = (Float) playerController.newWorldObject.getProperties().get("y");
    Float width = (Float) playerController.newWorldObject.getProperties().get("width");
    Float height = (Float) playerController.newWorldObject.getProperties().get("height");

  */
    private int tempCollisionlayerwidth = 50;

    private int zaloonExitX = 224;
    private int zaloonExitY = 803;

    private boolean isEntrance;
    private Position entrancePosition;


    public WorldController(Game game, PlayerController controller, GameView view) {
        this.playerController = controller;
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
                setExit();
                view.setWorld(new TmxMapLoader().load("maps/horsalmaskin.tmx"));
                playerController.updateCollisionController();
                enterHorsal(x,y);
                break;

            case EDIT:
                setExit();
                view.setWorld(new TmxMapLoader().load("maps/hubbeneditsand.tmx"));
                playerController.updateCollisionController();
                enterEdit(x,y);
                break;

            case HUBBEN:
                setEntrance(x,y);
                view.setWorld(new TmxMapLoader().load("maps/hubbek.tmx"));
                playerController.updateCollisionController();
                enterHubben();
                break;

            case ZALOONEN:
                setEntrance(x,y);
                view.setWorld(new TmxMapLoader().load("maps/zaloonen.tmx"));
                playerController.updateCollisionController();
                enterZaloonen();
                break;

            default:

                System.out.println("Ohoh! Something went wrong");
                break;
        }
    }

    //TODO: Doesn't work for all scenarios
    public void enterHorsal(float x, float y){

        if(y < zaloonExitX && x < zaloonExitY){
            model.player.setPosition(entrancePosition.getX(), entrancePosition.getY());
        }

        if(x > view.getWorldWidth() - tempCollisionlayerwidth) {
            model.player.setPosition(tempCollisionlayerwidth, y);
            System.out.println("hej");
        }

        else{
            model.player.setPosition(view.getWorldWidth()+tempCollisionlayerwidth, y);
            System.out.println("goddag");
        }

    }

    public void enterEdit(float x, float y){

        if(x < tempCollisionlayerwidth) {
            model.player.setPosition(view.getWorldWidth()-tempCollisionlayerwidth, y);
        }

        else{
            model.player.setPosition(view.getWorldWidth()+tempCollisionlayerwidth, y);
        }

    }

    public void enterHubben(){
        model.player.setPosition(1,1);
    }

    public void enterZaloonen(){
        model.player.setPosition(1,50);
    }

    public void setEntrance(float x, float y){
        isEntrance = true;
        entrancePosition.setPosition(x,y);
    }

    public void setExit(){
        isEntrance = false;
    }
}
