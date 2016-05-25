package test;

import com.crap.game.model.CollisionModel;
import com.crap.game.model.TileType;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionModelTest {


   @Test
    public void testIsBlocked(){
       CollisionModel collisionModel = new CollisionModel();
       collisionModel.setTypeOfTile(TileType.SOLID_TILE);
       assertTrue(collisionModel.isBlocked());
       collisionModel.setTypeOfTile(TileType.WALKABLE_TILE);
       assertTrue(!collisionModel.isBlocked());
       collisionModel.setTypeOfTile(TileType.SLOWER_TILE);
       assertTrue(!collisionModel.isBlocked());

    }

    @Test
    public void testIsSlow(){
        CollisionModel collisionModel = new CollisionModel();
        collisionModel.setTypeOfTile(TileType.SLOWER_TILE);
        assertTrue(collisionModel.isSlow());
        collisionModel.setTypeOfTile(TileType.WALKABLE_TILE);
        assertTrue(!collisionModel.isSlow());
        collisionModel.setTypeOfTile(TileType.SOLID_TILE);
        assertTrue(!collisionModel.isSlow());
    }


}