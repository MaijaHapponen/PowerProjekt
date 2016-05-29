package com.crap.game.model;


import com.crap.game.model.character.humaninteraction.InteractHuman;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rebeccafinne on 16-05-24.
 */
public class InteractHumanTest {


    @Test
    public void testSetCurrentString(){
        String hej = "Hej";
        String tjo = "Tjo";
        String [] s = new String[]{hej, tjo};
        InteractHuman interactHuman = new InteractHuman(s, hej);
        interactHuman.setCurrentString("down");
        assertTrue(interactHuman.getCurrentString().equals(tjo));
        interactHuman.setCurrentString("down");
        assertTrue(interactHuman.getCurrentString().equals(hej));
        interactHuman.setCurrentString("up");
        assertTrue(interactHuman.getCurrentString().equals(tjo));
        interactHuman.setCurrentString("up");
        assertTrue(interactHuman.getCurrentString().equals(hej));
    }

    @Test
    public void testSettersAndGetters() {
        String hej = "Hej";
        String tjo = "Tjo";
        String[] s = new String[]{hej, tjo};
        InteractHuman interactHuman = new InteractHuman(s, hej);
        assertTrue(interactHuman.getCurrentStringNbr() == 0);
        interactHuman.setIsMascot(true);
        assertTrue(interactHuman.getIsMascot());
        interactHuman.setIsProgramme(true);
        assertTrue(interactHuman.getIsProgramme());
    }
}
