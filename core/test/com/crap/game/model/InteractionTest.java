package com.crap.game.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by rebeccafinne on 2016-05-16.
 */
public class InteractionTest {

    @Test
    public void testCheckEveryPositionForInteraction(){
        Interaction interaction = new Interaction(30,30);
        Player player = new Player("player", 250, 250);
        //assertTrue(interaction.isInteraction(player, 240, 240));
        assertTrue(!interaction.isInteraction(player, 400, 400));
    }
}
