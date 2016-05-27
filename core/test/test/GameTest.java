package test;

import com.crap.game.model.Constants;
import com.crap.game.model.Game;
import static org.junit.Assert.*;

import com.crap.game.model.Mascot;
import org.junit.Test;

/**
 * Created by rebeccafinne on 2016-05-10.
 */
public class GameTest {


    @Test
    public void testIsGameOver(){
        Game game = new Game();
        game.getProgress().mascotCaught(game.getMascots().get(3));
        game.getProgress().mascotCaught(game.getMascots().get(2));
        game.getProgress().mascotCaught(game.getMascots().get(1));
        assertTrue(!game.isGameOver());
        //game.getProgress().mascotCaught(game.getMascots().get(0));
        //assertTrue(game.isGameOver());

    }

    @Test
    public void testMascotCaught(){
        Game game = new Game();
        Mascot mascot = game.getMascots().get(0);
        game.mascotCaught(mascot);
        assertTrue(game.getProgress().getMascotsCaught().get(0).equals(mascot));
    }



    @Test
    public void testEnterRooms() {
        Game game = new Game();
        game.enterZaloonen();
        assertTrue(game.player.getPosition().getX() == Constants.ZALOON_ENTRY_X);
        assertTrue(game.player.getPosition().getY() == Constants.ZALOON_ENTRY_Y);
        game.enterHubben();
        assertTrue(game.player.getPosition().getX() == Constants.HUBBEN_ENTRY_X);
        assertTrue(game.player.getPosition().getY() == Constants.HUBBEN_ENTRY_Y);
    }

    @Test
    public void testGettersAndSetters(){
        Game game = new Game();
        game.setNewWorld(true);
        assertTrue(game.getNewWorld());
        game.setPreviousRoom(Game.Worlds.EDIT);
        assertTrue(game.getPreviousRoom().equals(Game.Worlds.EDIT));
        game.setEntrance(50,50);
        assertTrue((game.getEntrancePosition().getX() == 50) && (game.getEntrancePosition().getY() == 50));
        game.createHumans();
        assertTrue(game.getHumans().equals(game.humans));
        game.createMascots();
        assertTrue(game.getMascots().equals(game.mascots));
        game.setCurrectWorld(Game.Worlds.EDIT);
        assertTrue(game.getCurrectWorld().equals(Game.Worlds.EDIT));

    }

}
