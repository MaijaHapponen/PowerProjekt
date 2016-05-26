package test;

import com.crap.game.Main;
import com.crap.game.model.Game;
import static org.junit.Assert.*;

import com.crap.game.model.Mascot;
import com.crap.game.model.Progress;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by rebeccafinne on 2016-05-10.
 */
public class GameTest {


    @Test
    public void testIsGameOver(){
        Game game = new Game();
        game.getProgress().mascotCaught(game.getMascots().get(0));
        game.getProgress().mascotCaught(game.getMascots().get(0));
        game.getProgress().mascotCaught(game.getMascots().get(0));
        game.getProgress().mascotCaught(game.getMascots().get(0));
        assertTrue(game.isGameOver());
    }

    //TODO write tests for create mascots and human methods??

}
