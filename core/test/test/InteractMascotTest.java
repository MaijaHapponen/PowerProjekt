package test;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.crap.game.model.InteractMascot;
import org.junit.Test;
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
        String[] l = new String [] {first, second};
        InteractMascot interactMascot;
        interactMascot = new InteractMascot(l, question);
        interactMascot.setCurrentString("down");
        assertTrue(interactMascot.getCurrentString().equals(second));
        interactMascot.setCurrentString("down");
        assertTrue(interactMascot.getCurrentString().equals(first));

    }
}
