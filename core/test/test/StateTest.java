package test;


import static org.junit.Assert.*;

import com.badlogic.gdx.Gdx;
import com.crap.game.Main;
import com.crap.game.model.Game;
import com.crap.game.model.State;
import com.crap.game.view.MenuView;
import org.junit.Test;



/**
 * Created by rebeccafinne on 2016-05-18.
 */
public class StateTest {


    @Test
    public void testUpdateState(){
        Main main = new Main();
        Game game = new Game(main);
        State.GameStates gameStates;
        State state = new State(game);
        com.badlogic.gdx.Game game1;
        MenuView menuView = new MenuView();
        state.updateState(State.GameStates.STARTMENU);
        assertTrue(game.getScreen() == menuView);
    }
}
