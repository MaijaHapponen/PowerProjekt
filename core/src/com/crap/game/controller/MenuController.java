package com.crap.game.controller;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.crap.game.model.Menu;
import com.crap.game.model.State;
import com.crap.game.view.MenuView;

/**
 * Created by Maija on 2016-05-11.
 */
public class MenuController extends InputAdapter implements ApplicationListener{

    MenuView menuView;
    Menu menuModel;
    HowToPlayController howToPlayController;
    public MenuController(MenuView menuView){
        this.menuView=menuView;
        this.menuModel = menuView.getMenuModel();
        this.howToPlayController = new HowToPlayController();

        Gdx.input.setInputProcessor(this);
    }

    public boolean keyDown(int keycode){
        if(menuView.getGameOver()){
            if(keycode == Input.Keys.ENTER){
                StateController.updateState(State.GameStates.STARTMENU);
            }
        }
        else {
            if (keycode == Input.Keys.ENTER) {
                menuView.setScreen();
            }
            if (keycode == Input.Keys.DOWN) {
                menuModel.setCurrentItem("down");
            }
            if (keycode == Input.Keys.UP) {
                menuModel.setCurrentItem("up");
            }
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
