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
        float playerPosX = player.getPosition().getX();
        float playerPosY = player.getPosition().getY();
        player.moveUp(500);
        assertTrue(player.getPosition().getX() == playerPosX);
        assertTrue(player.getPosition().getY() == playerPosY+player.getNormalSpeed());
    }

    @Test
    public void testMoveDown(){
        Player player = new Player();
        float playerPosX = player.getPosition().getX();
        float playerPosY = player.getPosition().getY();
        player.moveDown();
        assertTrue(player.getPosition().getY() == playerPosX-player.getNormalSpeed());
        assertTrue(player.getPosition().getX() == playerPosY);
    }

    @Test
    public void testMoveLeft(){
        Player player = new Player();
        float playerPosX = player.getPosition().getX();
        float playerPosY = player.getPosition().getY();
        player.moveLeft();
        assertTrue(player.getPosition().getX() == playerPosX-player.getNormalSpeed());
        assertTrue(player.getPosition().getY() == playerPosY);
    }

    @Test
    public void testMoveRight(){
        Player player = new Player();
        float playerPosX = player.getPosition().getX();
        float playerPosY = player.getPosition().getY();
        player.moveRight(500);
        assertTrue(player.getPosition().getY() == playerPosX);
        assertTrue(player.getPosition().getX() == playerPosY+player.getNormalSpeed());
    }


}