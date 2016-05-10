package test;

import com.crap.game.model.Game;
import static org.junit.Assert.*;

import com.crap.game.model.Mascot;
import com.crap.game.model.Progress;
import org.junit.Test;
/**
 * Created by rebeccafinne on 2016-05-10.
 */
public class GameTest {


    @Test
    public void testIsGameOver(){
        Game game = new Game();
        Progress progress = new Progress();
        Mascot mascot = new Mascot("Hej");
        progress.getMascotsInGame().add(mascot);
        progress.mascotCaught(mascot);
        assertTrue(game.isGameOver() == true);
    }

    //TODO write tests for create mascots and human methods??

}
