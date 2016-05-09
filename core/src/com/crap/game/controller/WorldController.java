package com.crap.game.controller;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.crap.game.model.Game;
import com.crap.game.view.GameView;


/**
 * Created by andrea on 2016-04-28.
 */
public class WorldController {

    private Game world;
    private GameView view;
    private Game.Worlds worlds;

    public WorldController(GameView view, Game world) {
        this.view = view;
        this.world = world;
    }

    public void changeWorld(Game.Worlds worlds){
        switch (worlds) {
            case HORSAL:
                view.setWorld(new TmxMapLoader().load("maps/horsalmaskin.tmx"));
                break;

            case EDIT:
                view.setWorld(new TmxMapLoader().load("maps/hubbeneditsand.tmx"));
                break;

            case PARKING:
                view.setWorld(new TmxMapLoader().load("maps/parkingtemplate.tmx"));

            default:
                System.out.println("Ohoh! Something went wrong");
                break;
        }
    }
}
