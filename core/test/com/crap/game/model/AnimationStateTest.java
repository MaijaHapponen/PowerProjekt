package com.crap.game.model;

import com.crap.game.model.information.enums.AnimationState;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class AnimationStateTest {

    @Test
    public void testAnimation(){
        AnimationState animationState = AnimationState.STANDING_BACK;
        assertTrue(animationState.equals(AnimationState.STANDING_BACK));
    }
}