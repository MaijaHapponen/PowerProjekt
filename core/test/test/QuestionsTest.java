package test;
import com.crap.game.model.Mascot;
import com.crap.game.model.Questions;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Created by rebeccafinne on 16-05-24.
 */
public class QuestionsTest {

    @Test
    public void testSetQuestions(){
        Mascot mascot = new Mascot("kalleAnka");
        ArrayList<Mascot> mascots = new ArrayList<Mascot>();
        mascots.add(mascot);
        Questions questions = new Questions(mascots);
        questions.setQuestions(mascots);
        assertTrue(mascot.getQuestion().getQuestion().equals("What is kalle ankas love interest called?"));
    }

}
