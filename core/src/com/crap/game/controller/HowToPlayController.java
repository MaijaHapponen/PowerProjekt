package com.crap.game.controller;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.crap.game.view.HowToPlayView;

/**
 * Created by rebeccafinne on 2016-05-17.
 */
public class HowToPlayController extends InputAdapter implements ApplicationListener{

    private HowToPlayView howToPlayView;

    public HowToPlayController(){
        this.howToPlayView = new HowToPlayView();
        Gdx.input.setInputProcessor(this);
    }

    public boolean keyDown(int keycode){
        if(keycode == Input.Keys.ENTER){
            howToPlayView.setGame();

        }if(keycode == Input.Keys.BACKSPACE){
            howToPlayView.setMenu();
        }
        return true;
    }

    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
