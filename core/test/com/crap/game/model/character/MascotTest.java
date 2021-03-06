package com.crap.game.model.character;

import com.crap.game.model.information.Constants;
import com.crap.game.model.information.enums.Direction;
import org.junit.Test;

import static org.junit.Assert.*;

public class MascotTest {

    @Test
    public void testUpdateDirections(){
        Mascot mascot = new Mascot("hej");
        mascot.setWalkAwayDirection(Direction.DOWN);
        mascot.updateDirections();
        assertTrue(mascot.getWalkAwayDirection() == Direction.NO_DIRECTION);
    }

    @Test
    public void testGettersAndSetters(){
        Mascot mascot = new Mascot("HEJ");
        mascot.setNormalSpeed();
        assertTrue(mascot.getSpeed() == Constants.NORMAL_SPEED);
        mascot.setCaught(true);
        assertTrue(mascot.isCaught());
        mascot.setWidthAndHeight(30, 40);
        assertTrue(mascot.getWidth() == 30);
        assertTrue(mascot.getHeight() == 40);
        mascot.setSlowerSpeed();
        assertTrue(mascot.getSpeed() == Constants.SLOWER_SPEED);
    }
}
