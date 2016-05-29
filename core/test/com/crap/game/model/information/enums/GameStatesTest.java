package com.crap.game.model.information.enums;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameStatesTest {

    @Test
    public void testGameStates(){
        GameStates gameStates = GameStates.CHECKQUESTION;
        assertTrue(gameStates.equals(GameStates.CHECKQUESTION));
    }
}