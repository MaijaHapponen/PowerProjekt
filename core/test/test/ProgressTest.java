package test;

import com.crap.game.model.Mascot;
import com.crap.game.model.Progress;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by rebeccafinne on 2016-05-10.
 */
public class ProgressTest {


    @Test
    public void testAreAllMascotsCaught(){
        Progress progress = new Progress();
        Mascot mascot = new Mascot("hej");
        progress.getMascotsInGame().add(mascot);
        assertTrue(progress.areAllMascotsCaught());
        progress.mascotCaught(mascot);
        assertTrue(progress.areAllMascotsCaught());
    }

    @Test
    public void testMascotsCaught(){
        Progress progress = new Progress();
        Mascot mascot = new Mascot("TJO");
        progress.getMascotsInGame().add(mascot);
        progress.mascotCaught(mascot);
        assertTrue(progress.getMascotsCaught().contains(mascot));

    }
}
