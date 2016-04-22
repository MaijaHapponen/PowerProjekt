package test;

import com.crap.game.model.Position;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by se on 22/04/16.
 */
public class PositionTest {

    @Test
    public void testSetPosition() throws Exception {
        Position position = new Position();
        position.setPosition(3,8);
        assertNotNull(position.getX());
        assertNotNull(position.getY());
        assertTrue(position.getX() == 3);
        assertTrue(position.getY() == 8);
    }

    @Test
    public void testGetX() throws Exception {
        Position position = new Position(4,5);
        assertNotNull(position.getX());
        assertTrue(position.getX() == 4);
    }

    @Test
    public void testGetY() throws Exception {
        Position position = new Position(10,59);
        assertNotNull(position.getY());
        assertTrue(position.getY() == 59);
    }
}