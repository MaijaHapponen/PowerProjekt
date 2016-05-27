package test;

import com.crap.game.model.AnimationState;
import com.crap.game.model.TextForInteraction;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by rebeccafinne on 2016-04-22.
 */
public class TextForInteractionTest {

    @Test
    public void testTextForInteraction(){
        int textForInteraction = TextForInteraction.alternativesPlacementX;
        assertTrue(textForInteraction == TextForInteraction.alternativesPlacementX);
    }
}