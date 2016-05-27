package test;

import static com.crap.game.model.Constants.NORMAL_SPEED;
import static org.junit.Assert.*;

import com.crap.game.model.*;

import com.crap.game.model.Character;
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
        Player player = new Player("Hej", 20, 80);
        float playerPosX = player.getPosition().getX();
        float playerPosY = player.getPosition().getY();
        player.moveDown();
        player.nextStepDown();
        assertTrue(player.getPosition().getY() == playerPosX - Constants.NORMAL_SPEED);
        assertTrue(player.getPosition().getX() == playerPosY);
    }

    @Test
    public void testNextStepLeft(){
        Player player = new Player("Hej", 20, 20);
        float playerPosX = player.getPosition().getX();
        float playerPosY = player.getPosition().getY();
        player.moveLeft();
        player.nextStepLeft();
        assertTrue(player.getPosition().getX() == playerPosX-Constants.NORMAL_SPEED);
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
        assertTrue(player.getPosition().getX() == playerPosY+Constants.NORMAL_SPEED);
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

    /*
    //Can't be tested because of random?
    @Test
    public void testChangeDirection() {
        Player player = new Player("HEJ", 200, 200);
        player.setWalkAwayDirection(Direction.LEFT);
        int walkAwayState = 20;
        player.changeDirection(walkAwayState);
        System.out.println(player.getLastDirection());
        System.out.println(player.getWalkAwayDirection());
        assertTrue(player.getWalkAwayDirection().equals(Direction.NO_DIRECTION));
    }
    */

    @Test
    public void testGetWorld(){
        Game.Worlds world = Game.Worlds.EDIT;
        Player player = new Player("HEJ", 50, 50);
        player.setWorld(world);
        assertTrue(player.getWorld().equals(Game.Worlds.EDIT));
    }

    @Test
    public void testDecideNewDirection() {
        Player player = new Player("HEJ", 50, 50);
        player.setWalkAwayDirection(Direction.DOWN);
        player.updateDirections();
        player.decideNewDirection();
        assertFalse(player.getWalkAwayDirection().equals(Direction.UP));
    }
}