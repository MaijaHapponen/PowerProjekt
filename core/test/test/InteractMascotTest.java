package test;

import com.crap.game.model.InteractMascot;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rebeccafinne on 16-05-24.
 */
public class InteractMascotTest {


    @Test
    public void testSetCurrentLabel(){

        String question = "HEJ";
        String first = "FSA";
        String second = "fdsjfs";
        List<String> l = Arrays.asList(first, second);

        InteractMascot interactMascot;
        interactMascot = new InteractMascot(l);
        interactMascot.setCurrentString("nextStepDown");
        assertTrue(interactMascot.getCurrentString().equals(second));
        interactMascot.setCurrentString("nextStepDown");
        assertTrue(interactMascot.getCurrentString().equals(first));


    }
}
