package com.crap.game.model;

import static org.junit.Assert.*;

import com.crap.game.model.character.Mascot;
import com.crap.game.model.information.Constants;
import com.crap.game.model.primary.CRAP;
import org.junit.Test;

/**
 * Created by rebeccafinne on 2016-05-10.
 */
public class CRAPTest {

    @Test
    public void testIsGameOver(){
        CRAP CRAP = new CRAP();

        CRAP.mascotCaught(CRAP.getMascots().get(3));
        CRAP.mascotCaught(CRAP.getMascots().get(2));
        CRAP.mascotCaught(CRAP.getMascots().get(1));
        assertTrue(!CRAP.isGameOver());
        //CRAP.mascotCaught(CRAP.getMascots().get(0));
        //assertTrue(CRAP.isGameOver());
    }

    @Test
    public void testMascotCaught(){
        CRAP CRAP = new CRAP();
        Mascot mascot = CRAP.getMascots().get(0);
        CRAP.mascotCaught(mascot);
        assertTrue(CRAP.getProgress().getMascotsCaught().get(0).equals(mascot));
    }



    @Test
    public void testEnterRooms() {
        CRAP CRAP = new CRAP();
        CRAP.enterZaloonen();
        assertTrue(CRAP.player.getPosition().getX() == Constants.ZALOON_ENTRY_X);
        assertTrue(CRAP.player.getPosition().getY() == Constants.ZALOON_ENTRY_Y);
        CRAP.enterHubben();
        assertTrue(CRAP.player.getPosition().getX() == Constants.HUBBEN_ENTRY_X);
        assertTrue(CRAP.player.getPosition().getY() == Constants.HUBBEN_ENTRY_Y);
    }

    @Test
    public void testGettersAndSetters(){
        CRAP CRAP = new CRAP();
        CRAP.setNewWorld(true);
        assertTrue(CRAP.getNewWorld());
        CRAP.setPreviousRoom(com.crap.game.model.primary.CRAP.Worlds.EDIT);
        assertTrue(CRAP.getPreviousRoom().equals(com.crap.game.model.primary.CRAP.Worlds.EDIT));
        CRAP.setEntrance(50,50);
        assertTrue((CRAP.getEntrancePosition().getX() == 50) && (CRAP.getEntrancePosition().getY() == 50));
        CRAP.createHumans();
        assertTrue(CRAP.getHumans().equals(CRAP.humans));
        CRAP.createMascots();
        assertTrue(CRAP.getMascots().equals(CRAP.mascots));
<<<<<<< HEAD
        CRAP.setCurrectWorld(com.crap.game.model.primary.CRAP.Worlds.EDIT);
        assertTrue(CRAP.getCurrectWorld().equals(com.crap.game.model.primary.CRAP.Worlds.EDIT));
=======
        CRAP.setCurrentWorld(com.crap.game.model.CRAP.Worlds.EDIT);
        assertTrue(CRAP.getCurrentWorld().equals(com.crap.game.model.CRAP.Worlds.EDIT));
>>>>>>> 51bfcf2d64a859a2c39b8aa75f125a0250c4477d

    }

}
