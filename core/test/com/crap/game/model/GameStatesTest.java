package com.crap.game.model;

import com.crap.game.model.information.enums.GameStates;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class GameStatesTest {

    @Test
    public void testGameStates(){
        GameStates gameStates = GameStates.CHECKQUESTION;
        assertTrue(gameStates.equals(GameStates.CHECKQUESTION));
    }
}