package test;

import static org.junit.Assert.*;

import com.crap.game.model.*;

import org.junit.Test;

/**
 * Created by se on 22/04/16.
 */
public class PlayerTest {

    @Test
    public void testNextStepUp() throws Exception {

        Player player = new Player("Hej", 20, 20);
        float playerPosX = 20;
        float playerPosY = 20;

        player.moveUp(500);
        player.nextStepUp();
        assertTrue(player.getPosition().getX() == playerPosX);
        assertTrue(player.getPosition().getY() == playerPosY + player.getSpeed());
    }

   @Test
    public void testNextStepDown(){
        Player player = new Player("Hej", 20, 20);
        float playerPosX = player.getPosition().getX();
        float playerPosY = player.getPosition().getY();
        player.moveDown();
        player.nextStepDown();
        assertTrue(player.getPosition().getY() == playerPosX - Constants.normalSpeed);
        assertTrue(player.getPosition().getX() == playerPosY);
    }

    @Test
    public void testNextStepLeft(){
        Player player = new Player("Hej", 20, 20);
        float playerPosX = player.getPosition().getX();
        float playerPosY = player.getPosition().getY();
        player.moveLeft();
        player.nextStepLeft();
        assertTrue(player.getPosition().getX() == playerPosX-Constants.normalSpeed);
        assertTrue(player.getPosition().getY() == playerPosY);
    }

    @Test
    public void testNextStepRight(){
        Player player = new Player("Hej", 20, 20);
        float playerPosX = player.getPosition().getX();
        float playerPosY = player.getPosition().getY();
        player.moveRight(500);
        player.nextStepRight();
        assertTrue(player.getPosition().getY() == playerPosX);
        assertTrue(player.getPosition().getX() == playerPosY+Constants.normalSpeed);
    }

    @Test
    public void testPositionOutOfBounds(){
        Player player = new Player("hej", 499, 499);
        player.setPosition(499, 502);
        player.moveRight(500);
        assertTrue(player.positionOutOfBounds(500, 500));
        player.setPosition(502, 499);
        assertFalse(player.positionOutOfBounds(500, 500));
    }

    @Test
    public void testCanMoveCameraUp(){
        Player player = new Player("HEJ", 200, 499);
        assertFalse(player.canMoveCameraUp(500, 500));
    }

    @Test
    public void testCanMoveCameraDown(){
        Player player = new Player("HEJ", 200, 499);
        assertFalse(player.canMoveCameraDown(0, 0));
    }

    @Test
    public void testCanMoveCameraLeft(){
        Player player = new Player("HEJ", 200, 499);
        assertFalse(player.canMoveCameraLeft(0, 0));
    }

    @Test
    public void testCanMoveCameraRight(){
        Player player = new Player("HEJ", 200, 499);
        assertFalse(player.canMoveCameraRight(500, 500));
    }


}