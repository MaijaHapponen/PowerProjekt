package test;

import com.crap.game.model.CollisionModel;
import com.crap.game.model.Player;
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
        collisionModel.setTypeOfTile(TileType.NEW_WORLD);
        assertTrue(collisionModel.isBlocked());
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
        collisionModel.setTypeOfTile(TileType.NEW_WORLD);
        assertTrue(!collisionModel.isSlow());
    }
    @Test
    public void testIsNewWorld(){
        CollisionModel collisionModel = new CollisionModel();
        collisionModel.setTypeOfTile(TileType.SLOWER_TILE);
        assertTrue(!collisionModel.isNewWorld());
        collisionModel.setTypeOfTile(TileType.WALKABLE_TILE);
        assertTrue(!collisionModel.isNewWorld());
        collisionModel.setTypeOfTile(TileType.SOLID_TILE);
        assertTrue(!collisionModel.isNewWorld());
        collisionModel.setTypeOfTile(TileType.NEW_WORLD);
        assertTrue(collisionModel.isNewWorld());
    }
/*
    @Test
    public void testCheckIfCollide(){
        CollisionModel collisionModel = new CollisionModel();
        Player player = new Player("player",250,250);
        assertTrue(collisionModel.checkIfCollide(250, 250, 30, 30, player.getPosition().getX(), player.getPosition().getY()));
        assertTrue(!collisionModel.checkIfCollide(300, 300, 30, 30, player.getPosition().getX(), player.getPosition().getY()));
    }
    */
}