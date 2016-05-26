package test;

import com.crap.game.model.Direction;
import com.crap.game.model.Mascot;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rebeccafinne on 16-05-26.
 */
public class MascotTest {


    @Test
    public void testUpdateDirections(){
        Mascot mascot = new Mascot("hej");

        mascot.setWalkAwayDirection(Direction.DOWN);
        mascot.updateDirections();
        assertTrue(mascot.getWalkAwayDirection() == Direction.NO_DIRECTION);

    }
}
