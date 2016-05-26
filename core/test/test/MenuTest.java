package test;


import com.crap.game.model.Menu;
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
        menu.setCurrentItem("down");
        assertTrue(menu.getCurrentItem().equals(f));
        menu.setCurrentItem("down");
        assertTrue(menu.getCurrentItem().equals(t));
    }



}
