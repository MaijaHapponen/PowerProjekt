package com.crap.game.model;


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

    @Test
    public void testCheckIfCollide() {
        CollisionModel collisionModel = new CollisionModel();
        Player player = new Player("player", 250, 250);
        player.setWidthAndHeight(30, 30);
        assertTrue(collisionModel.checkIfCollide(240, 240, player.getWidth(), player.getHeight(),
                player.getPosition().getX(), player.getPosition().getY()));
        assertTrue(!collisionModel.checkIfCollide(300, 300, player.getWidth(), player.getHeight(),
                player.getPosition().getX(), player.getPosition().getY()));
    }
}