package com.crap.game.controller;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.crap.game.model.Game;
import com.crap.game.view.GameView;

import static com.crap.game.model.Constants.*;
import static com.crap.game.model.Game.Worlds.*;

/**
 * Created by andrea on 2016-04-28.
 */
public class WorldController {

    private Game model;
    private PlayerController playerController;
    private CharacterController characterController;
    private GameView view;

    public WorldController(Game game, PlayerController controller, CharacterController characterController, GameView view) {

        this.playerController = controller;
        this.characterController = characterController;

        this.model = game;
        this.view = view;
    }

    public void setWorld(Game.Worlds worlds){

        float x = playerController.getCharacter().getPosition().getX();
        float y = playerController.getCharacter().getPosition().getY();
        model.setCurrectWorld(worlds);

        switch (worlds) {

            case HORSAL:
                enterHorsal(x,y);
                model.setExit();
                view.setWorld(new TmxMapLoader().load("maps/horsalmaskin.tmx"));
                playerController.updateCollisionController();
                model.setPreviousRoom(HORSAL);
                break;

            case EDIT:
                enterEdit(x,y);
                model.setExit();
                view.setWorld(new TmxMapLoader().load("maps/hubbeneditsand.tmx"));
                playerController.updateCollisionController();
                model.setPreviousRoom(EDIT);
                characterController.updateCollisionController();
                break;

            case HUBBEN:
                model.setEntrance(x,y);
                model.enterHubben();
                view.setWorld(new TmxMapLoader().load("maps/hubbek.tmx"));
                playerController.updateCollisionController();
                model.setPreviousRoom(HUBBEN);
                characterController.updateCollisionController();
                break;

            case ZALOONEN:
                model.setEntrance(x,y);
                model.enterZaloonen();
                view.setWorld(new TmxMapLoader().load("maps/zaloonen.tmx"));
                playerController.updateCollisionController();
                model.setPreviousRoom(ZALOONEN);
                characterController.updateCollisionController();
                break;

            default:

                System.out.println("Ohoh! Something went wrong");
                break;
        }
    }

    public void enterHorsal(float x, float y){

        if(model.getPreviousRoom() == ZALOONEN){
            model.player.setPosition(model.getEntrancePosition().getX(), model.getEntrancePosition().getY());
        }

        if(x > view.getWorldWidth() - tempCollisionlayerwidth) {
            model.player.setPosition(tempCollisionlayerwidth, y);
        }

        else if(x < tempCollisionlayerwidth){
            model.player.setPosition(view.getWorldWidth()+tempCollisionlayerwidth, y);
        }
    }

    public void enterEdit(float x, float y){

        if(model.getPreviousRoom() == HUBBEN){
            model.player.setPosition(model.getEntrancePosition().getX(), model.getEntrancePosition().getY());
        }

        else if(x < tempCollisionlayerwidth) {
            model.player.setPosition(view.getWorldWidth()-tempCollisionlayerwidth, y);
        }

        else if (x > view.getWorldWidth() - tempCollisionlayerwidth){
            model.player.setPosition(view.getWorldWidth()+tempCollisionlayerwidth, y);
        }

    }
}
