package com.crap.game.model.information.enums;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AnimationStateTest {

    @Test
    public void testAnimation(){
        AnimationState animationState = AnimationState.STANDING_BACK;
        assertTrue(animationState.equals(AnimationState.STANDING_BACK));
    }
}