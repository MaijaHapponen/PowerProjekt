package com.crap.game.controller;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.crap.game.model.Game;
import com.crap.game.view.WorldView;


/**
 * Created by andrea on 2016-04-28.
 */
public class WorldController {

    private Game game;
    private WorldView view;
    private Game.Worlds worlds;

    public WorldController(WorldView view, Game game) {
        this.view = view;
        this.game = game;
    }

    public void changeWorld(Game.Worlds worlds){
        switch (worlds) {
            case HORSAL:
                view.setWorld(new TmxMapLoader().load("maps/horsalmaskin.tmx"));
                game.player.setPosition(1,1); //TODO: Change value to correct location
                break;

            case EDIT:
                view.setWorld(new TmxMapLoader().load("maps/hubbeneditsand.tmx"));
                game.player.setPosition(2,2); //TODO: Change value to correct location
                break;

            case PARKING:
                view.setWorld(new TmxMapLoader().load("maps/parkingtemplate.tmx"));
                game.player.setPosition(1,1); //TODO: Change value to correct location
                break;
            default:
                System.out.println("Ohoh! Something went wrong");
                break;
        }
    }
}
