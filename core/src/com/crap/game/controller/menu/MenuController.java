package com.crap.game.controller.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.crap.game.controller.game.primary.StateController;
import com.crap.game.model.information.enums.GameStates;
import com.crap.game.model.menu.Menu;
import com.crap.game.model.information.TextForInteraction;
import com.crap.game.view.menu.MenuView;

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
                menuModel.setCurrentItem("nextStepDown");
            }
            if (keycode == Input.Keys.UP) {
                menuModel.setCurrentItem("nextStepUp");
            }
        }
        return true;
    }

    public void changeScreen(){
        if(menuModel.getCurrentItem().equals(TextForInteraction.playTheGame)){
            StateController.updateState(GameStates.PLAY);
            menuView.dispose();
        }else if(menuModel.getCurrentItem().equals(TextForInteraction.howToPlay)){
            StateController.updateState(GameStates.HOWTOPLAY);
        }else if(menuModel.getCurrentItem().equals(TextForInteraction.exit)){
            System.exit(0);
        }
    }

}
