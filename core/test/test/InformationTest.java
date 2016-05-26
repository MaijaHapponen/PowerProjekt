package test;

import com.crap.game.model.Human;
import com.crap.game.model.Information;
import org.junit.Test;
import static org.junit.Assert.*;


import java.util.ArrayList;

/**
 * Created by rebeccafinne on 16-05-24.
 */
public class InformationTest {


    @Test
    public void testSetInformation(){
        ArrayList<Human> humans = new ArrayList<Human>();
        Human h = new Human("EHuman");
        humans.add(h);
        Information information = new Information(humans);
        information.setInformation(humans);
        assertTrue(h.getInformationAboutProgramme().equals("Kalle Ankas love interest is called Kajsa"));
        assertTrue(h.getInformationAboutLocation().equals("Kalle Anka likes to hang out in the sandbox"));
    }
}
