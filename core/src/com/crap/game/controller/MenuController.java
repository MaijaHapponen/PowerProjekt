package com.crap.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.crap.game.model.GameStates;
import com.crap.game.model.Menu;
import com.crap.game.view.MenuView;

/**
 * Created by Maija on 2016-05-11.
 */
public class MenuController extends InputAdapter{

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
                StateController.updateState(GameStates.STARTMENU);
                menuView.dispose();
            }
        }
        else {
            if (keycode == Input.Keys.ENTER) {
                changeScreen();
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

    //TODO: Remove
    public void changeScreen(){
        if(menuModel.getCurrentItem().equals("Play the game")){
            StateController.updateState(GameStates.PLAY);
            menuView.dispose();
        }else if(menuModel.getCurrentItem().equals("How to play")){
            StateController.updateState(GameStates.HOWTOPLAY);
        }else if(menuModel.getCurrentItem().equals("Exit")){
            System.exit(0);
        }
    }

}
