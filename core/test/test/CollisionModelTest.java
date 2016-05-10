package test;

import com.crap.game.model.CollisionModel;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class CollisionModelTest {


   @Test
    public void testIsBlocked(){
        CollisionModel collisionModel = new CollisionModel();
        collisionModel.setTypeOfTile(CollisionModel.tileType.SOLID_TILE);
        assertTrue(collisionModel.isBlocked() == true);

    }

    @Test
    public void testIsSlow(){
        CollisionModel collisionModel = new CollisionModel();
        collisionModel.setTypeOfTile(CollisionModel.tileType.SLOWER_TILE);
        assertTrue(collisionModel.isSlow() == true);
    }


}