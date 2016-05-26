package test;

import com.crap.game.model.Mascot;
import com.crap.game.model.Progress;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Created by rebeccafinne on 2016-05-10.
 */
public class ProgressTest {


   /* @Test
    public void testAreAllMascotsCaught(){
        Mascot mascot = new Mascot("hej");
        ArrayList<Mascot> inGame = new ArrayList<Mascot>();
        inGame.add(mascot);
        Progress progress = new Progress(inGame);
        assertTrue(progress.areAllMascotsCaught());
        progress.mascotCaught(mascot);
        assertTrue(progress.areAllMascotsCaught());
    }*/

    @Test
    public void testMascotsCaught(){
        Mascot mascot = new Mascot("TJO");
        ArrayList<Mascot> inGame = new ArrayList<Mascot>();
        inGame.add(mascot);
        Progress progress = new Progress(inGame);
        progress.mascotCaught(mascot);
        assertTrue(progress.getMascotsCaught().contains(mascot));

    }
}
