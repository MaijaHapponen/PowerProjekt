package test;

import static org.junit.Assert.*;

import com.crap.game.model.Player;

import org.junit.Test;

/**
 * Created by se on 22/04/16.
 */
public class PlayerTest {

    @Test
    public void testMoveUp() throws Exception {
        Player player = new Player();
        player.moveUp();
        assertTrue(player.getPosition().getX() == 250);
        assertTrue(player.getPosition().getY() == 252);
    }

    @Test
    public void testMoveDown(){
        Player player = new Player();
        player.moveDown();
        assertTrue(player.getPosition().getY() == 248);
        assertTrue(player.getPosition().getX() == 250);
    }

    @Test
    public void testMoveLeft(){
        Player player = new Player();
        player.moveLeft();
        assertTrue(player.getPosition().getX() == 248);
        assertTrue(player.getPosition().getY() == 250);
    }

    @Test
    public void testMoveRight(){
        Player player = new Player();
        player.moveRight();
        assertTrue(player.getPosition().getY() == 250);
        assertTrue(player.getPosition().getX() == 252);
    }

    @Test
    public void testIsOutOfBounds(){
        Player player = new Player(1001, 1000);
        assertTrue(player.isOutOfBounds() == true);

    }

}