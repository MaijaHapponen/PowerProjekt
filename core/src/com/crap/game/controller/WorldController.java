package com.crap.game.controller;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.crap.game.model.CRAP;
import com.crap.game.view.CRAPView;

import static com.crap.game.model.Constants.*;
import static com.crap.game.model.CRAP.Worlds.*;

/**
 * Created by andrea on 2016-04-28.
 */
public class WorldController {

    private CRAP model;
    private PlayerController playerController;
    private HumanMascotController humanMascotController;
    private CRAPView view;

    public WorldController(CRAP CRAP, PlayerController controller, CharacterController characterController, CRAPView view) {

        this.playerController = controller;
        this.humanMascotController = humanMascotController;

        this.model = CRAP;
        this.view = view;
    }

    public void setWorld(CRAP.Worlds worlds){

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
                humanMascotController.updateCollisionController();
                break;

            case HUBBEN:
                model.setEntrance(x, y);
                model.enterHubben();
                view.setWorld(new TmxMapLoader().load("maps/hubbek.tmx"));
                playerController.updateCollisionController();
                model.setPreviousRoom(HUBBEN);
                humanMascotController.updateCollisionController();
                break;

            case ZALOONEN:
                model.setEntrance(x,y);
                model.enterZaloonen();
                view.setWorld(new TmxMapLoader().load("maps/zaloonen.tmx"));
                playerController.updateCollisionController();
                model.setPreviousRoom(ZALOONEN);
                humanMascotController.updateCollisionController();
                break;

            case HIDDEN_ROOM:
                model.setEntrance(x, y);
                playerController.updateCollisionController();
                humanMascotController.updateCollisionController();
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

        else if(x > view.getWorldWidth() - TEMP_COLLISION_LAYER_WIDTH) {
            model.player.setPosition(TEMP_COLLISION_LAYER_WIDTH, y);
        }

        else if(x < TEMP_COLLISION_LAYER_WIDTH){
            model.player.setPosition(view.getWorldWidth()+ TEMP_COLLISION_LAYER_WIDTH, y);
        }
    }

    public void enterEdit(float x, float y){

        if(model.getPreviousRoom() == HUBBEN){
            model.player.setPosition(model.getEntrancePosition().getX(), model.getEntrancePosition().getY());
        }

        else if(x < TEMP_COLLISION_LAYER_WIDTH) {
            model.player.setPosition(view.getWorldWidth()- TEMP_COLLISION_LAYER_WIDTH, y);
        }

        else if (x > view.getWorldWidth() - TEMP_COLLISION_LAYER_WIDTH){
            model.player.setPosition(view.getWorldWidth()+ TEMP_COLLISION_LAYER_WIDTH, y);
        }

    }
}
