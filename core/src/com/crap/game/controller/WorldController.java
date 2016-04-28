package com.crap.game.controller;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.crap.game.model.World;
import com.crap.game.view.WorldView;


/**
 * Created by andrea on 2016-04-28.
 */
public class WorldController {

    private World world;
    private WorldView view;
    private World.Worlds worlds;

    public WorldController(WorldView view, World world) {
        this.view = view;
        this.world = world;
    }

    public void changeWorld(World.Worlds worlds){
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
