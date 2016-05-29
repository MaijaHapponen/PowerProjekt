package com.crap.game.controller.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.crap.game.controller.game.primary.StateController;
import com.crap.game.model.information.enums.GameStates;
import com.crap.game.view.menu.HowToPlayView;

/**
 * Created by rebeccafinne on 2016-05-17.
 */
public class HowToPlayController extends InputAdapter {

    private HowToPlayView howToPlayView;

    public HowToPlayController(){
        this.howToPlayView = new HowToPlayView();
        Gdx.input.setInputProcessor(this);
    }

    public boolean keyDown(int keycode){
        if(keycode == Input.Keys.BACKSPACE){
            StateController.updateState(GameStates.STARTMENU);
            howToPlayView.dispose();
        }
        return true;
    }

}
