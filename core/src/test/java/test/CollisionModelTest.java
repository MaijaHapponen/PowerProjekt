package test;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.crap.game.model.CollisionModel;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionModelTest {

    CollisionModel collision = new CollisionModel();

    @Test
    public void testGetBlockedTiles() throws Exception {



    }

    @Test
    public void testIsCollision() throws Exception {
        Boolean block[][] = null;
        block[0][0] = false;
        block[1][0] = true;
        assertTrue(collision.isCollision(0, 0) == false);
    }
}