package com.crap.game.model.character.humaninteraction;


import com.crap.game.model.character.Human;
import org.junit.Test;
import static org.junit.Assert.*;


import java.util.ArrayList;

public class InformationTest {


    @Test
    public void testSetInformation(){
        ArrayList<Human> humans = new ArrayList<Human>();
        Human h = new Human("EHuman");
        humans.add(h);
        Information information = new Information(humans);
        information.setInformation(humans);
        assertTrue(h.getInformationAboutProgramme().equals("Kalle Ankas love interest is called Kajsa"));
        assertTrue(h.getInformationAboutLocation().equals("Kalle Anka likes to \n hang out in the sandbox"));
    }
}
