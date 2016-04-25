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
    TiledMap map;
    TiledMapTileLayer collisionLayer = (TiledMapTileLayer) map.getLayers().get("Collision");  //The layer with the collision objects

    @Test
    public void testSetBlockedTiles() throws Exception {
        boolean blocks[][] = null;
        blocks[0][0] = false;
        //TiledMapTileLayer.Cell cell = collisionLayer.getCell(0, 0);
        collision.setBlockedTiles();
        assertTrue(collision.getBlockedTiles(0, 0) == false);


    }

    @Test
    public void testGetBlockedTiles() throws Exception {
        boolean blocks[][] = null;
        blocks[0][0] = false;
        assertTrue(collision.getBlockedTiles(0, 0) == false);
    }
}