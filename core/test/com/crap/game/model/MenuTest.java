package com.crap.game.model;


import com.crap.game.model.menu.Menu;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by rebeccafinne on 16-05-24.
 */
public class MenuTest {


    @Test
    public void testSetCurrentItem(){
        String t = "fneafj";
        String f = "fdfse";
        String[] array = new String[]{t, f};
        String s = "fdjaaö";
        Menu menu = new Menu(s, array);
        assertTrue(menu.currentItemNumber() == 0);
        menu.setCurrentItem("nextStepDown");
        assertTrue(menu.getCurrentItem().equals(f));
        menu.setCurrentItem("nextStepDown");
        assertTrue(menu.getCurrentItem().equals(t));
        menu.setCurrentItem("nextStepUp");
        assertTrue(menu.getCurrentItem().equals(f));
    }

    @Test
    public void testSettersAndGetters() {
        String gameName = "CRAP";
        String alt1 = "alternative1";
        String alt2 = "alternative2";
        String[] alternatives = new String[]{alt1, alt2};
        Menu menu = new Menu(gameName, alternatives);
        assertTrue(menu.getGameName().equals(gameName));
        assertTrue(menu.amountOfItems() == alternatives.length);
        assertTrue(menu.getMenuItem(1).equals(alternatives[1]));
    }

}
