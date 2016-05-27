package test;

import com.crap.game.model.CollisionModel;
import com.crap.game.model.Player;
import com.crap.game.model.TileType;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class AnimationTest {

    /*
    package com.crap.game.model;

    public enum AnimationState {WALKING_FRONT, WALKING_BACK, WALKING_RIGHT, WALKING_LEFT, STANDING_FRONT,
        STANDING_BACK, STANDING_RIGHT, STANDING_LEFT}


    public enum DivisionConstant {
    consumer(1), office(2), production_printing(3);
}
For this enum I wrote a junit test as:

@Test
public void testDivisionConstantFromInt()
{
    DivisionConstant d  = DivisionConstant.fromInt(1);
    assertTrue((d.toName().compareToIgnoreCase("consumer") ==  0));
}
     */
    @Test
    public void testAnimation(){
        AnimationState
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