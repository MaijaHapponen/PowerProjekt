package com.crap.game.model.character.collision;

import static org.junit.Assert.*;

import com.crap.game.model.character.Player;
import org.junit.Test;

public class InteractionTest {

    @Test
    public void testCheckEveryPositionForInteraction(){
        Interaction interaction = new Interaction(30,30);
        Player player = new Player("player", 250, 250);
        //assertTrue(interaction.isInteraction(player, 240, 240));
        assertTrue(!interaction.isInteraction(player, 400, 400));
    }
}
