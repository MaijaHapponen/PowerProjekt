package test;
import com.crap.game.model.Mascot;
import com.crap.game.model.Questions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rebeccafinne on 16-05-24.
 */
public class QuestionsTest {

    @Test
    public void testSetQuestions(){
        Mascot mascot = new Mascot("luckyluke");
        ArrayList<Mascot> mascots = new ArrayList<Mascot>();
        mascots.add(mascot);
        Questions questions = new Questions(mascots);
        questions.setQuestions(mascots);
        assertTrue(mascot.getQuestion().getQuestion().equals("What is Lucky Lukes horse called?"));
        assertTrue(mascot.getQuestion().getAlternatives().get(0).equals("Holly Hunter"));
        assertTrue(mascot.getQuestion().getAlternatives().get(1).equals("Betty Bowler"));
        assertTrue(mascot.getQuestion().getCorrectAnswer() == 3);
    }
}
