package test;

import com.crap.game.model.Constants;
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

    @Test
    public void testGettersAndSetters(){
        Mascot mascot = new Mascot("HEJ");
        mascot.setNormalSpeed();
        assertTrue(mascot.getSpeed() == Constants.normalSpeed);
        mascot.setCaught(true);
        assertTrue(mascot.isCaught());
        mascot.setWidthAndHeight(30, 40);
        assertTrue(mascot.getWidth() == 30);
        assertTrue(mascot.getHeight() == 40);
        mascot.setSlowerSpeed();
        assertTrue(mascot.getSpeed() == Constants.slowerSpeed);
    }
}
