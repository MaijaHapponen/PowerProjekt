package com.crap.game.controller;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.crap.game.model.Game;
import com.crap.game.view.GameView;
/**
 * Created by andrea on 2016-04-28.
 */
public class WorldController {

    private Game model;
    private PlayerController playerController;
    private GameView view;

    public WorldController(Game game, PlayerController controller, GameView view) {
        this.playerController = controller;
        this.model = game;
        this.view = view;
    }

    public void setWorld(Game.Worlds worlds){
        /*
        Float x = (Float) playerController.newWorldObject.getProperties().get("x");
        Float y = (Float) playerController.newWorldObject.getProperties().get("y");
        Float width = (Float) playerController.newWorldObject.getProperties().get("width");
        Float height = (Float) playerController.newWorldObject.getProperties().get("height");

      */
        int tempCollisionlayerwidth = 50;
        //entrancePosition + tempCollisionlayerwidth

        int zaloonExitX = 224;
        int zaloonExitY = 803;
        int horsalEntranceX = 350;
        int horsalEntranceY = 310;

        switch (worlds) {
            case HORSAL:
                view.setWorld(new TmxMapLoader().load("maps/horsalmaskin.tmx"));
                playerController.updateCollisionController();
                enterHorsal(zaloonExitX, zaloonExitY, horsalEntranceX, horsalEntranceY, tempCollisionlayerwidth);
                break;

            case EDIT:
                view.setWorld(new TmxMapLoader().load("maps/hubbeneditsand.tmx"));
                playerController.updateCollisionController();
                enterEdit(tempCollisionlayerwidth);
                break;

            case HUBBEN:
                //entrancePosition.setPosition(playerController.getPlayerPositionX(), playerController.getPlayerPositionY());
                view.setWorld(new TmxMapLoader().load("maps/hubbek.tmx"));
                playerController.updateCollisionController();
                break;

            case ZALOONEN:
                //entrancePosition.setPosition(playerController.getPlayerPositionX(), playerController.getPlayerPositionY());
                view.setWorld(new TmxMapLoader().load("maps/zaloonen.tmx"));
                playerController.updateCollisionController();

            default:
                System.out.println("Ohoh! Something went wrong");
                break;
        }
    }

    //TODO: Doesn't work for all scenarios
    public void enterHorsal(float zaloonExitX, float zaloonExitY, float horsalEntranceX, float horsalEntranceY, float tempCollisionlayerwidth){
        if(playerController.getPlayerPositionY() < zaloonExitX && playerController.getPlayerPositionY() < zaloonExitY){
            model.player.setPosition(horsalEntranceX, horsalEntranceY);
        }
        else if(playerController.getPlayerPositionX() > view.getWorldWidth() -tempCollisionlayerwidth) {
            if(playerController.getPlayerPositionY() > 0) {
                model.player.setPosition(tempCollisionlayerwidth, playerController.getPlayerPositionY());
            }
        }
        else{
            model.player.setPosition(view.getWorldWidth()-tempCollisionlayerwidth, playerController.getPlayerPositionY());
         }
    }

    public void enterEdit(float tempCollisionlayerwidth){
        if(playerController.getPlayerPositionX() < tempCollisionlayerwidth) {
            model.player.setPosition(view.getWorldWidth()-tempCollisionlayerwidth, playerController.getPlayerPositionY());
        }
        else{
            model.player.setPosition(view.getWorldWidth()+tempCollisionlayerwidth, playerController.getPlayerPositionY());
        }
    }

    public void enterHubben(){
        model.player.setPosition(1,1);
    }

    public void enterZaloonen(){
        model.player.setPosition(1,50);
    }
}
