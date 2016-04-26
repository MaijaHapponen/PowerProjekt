package com.crap.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.crap.game.view.WorldView;
import com.crap.game.model.Player;

/**
 * Created by Lisa on 18/04/16.
 * Edited by Andrea on 2016-05-22
 */
public class Controller implements  InputProcessor{

    private WorldView view;
    private Player model;
    //private OrthographicCamera camera;

    public Controller(WorldView view, Player player){
        //this.camera = new OrthographicCamera();

        Gdx.input.setInputProcessor(this);
        this.view = view;
        this.model = player;
        this.view.setPlayer(model);
    }

    //public Player getPlayer(){
    //    return this.player;
    //}

    //public WorldView getView(){
    //    return this.view;
    //}

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        model.movePlayer(keycode);
        model.update();

        System.out.println(5);
        view.render();
        //float x = player.getX();
        //float y = player.getY();
        //camera.lookAt(x,y,0);
        return true;
    }

    @Override public boolean keyTyped(char character) { return false; }

    @Override public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override public boolean scrolled(int amount) {
        return false;
    }
}

