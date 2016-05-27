package test;

import com.crap.game.model.InteractMascot;
import com.crap.game.model.Mascot;
import com.crap.game.model.Question;
import org.junit.Test;

import java.util.ArrayList;
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
        interactMascot.setCurrentString("nextStepUp");
        assertTrue(interactMascot.getCurrentString().equals(second));
        interactMascot.setCurrentString("nextStepUp");
        assertTrue(interactMascot.getCurrentString().equals(first));
    }

    @Test
    public void testIsRightAnswer(){
        Mascot mascot = new Mascot("hej");
        List<String> answers = Arrays.asList("eh", "hej");
        InteractMascot interactMascot = new InteractMascot(answers);
        String question = "tjotjo";
        Question forMascot = new Question(question, answers, 1);
        mascot.setQuestion(forMascot);
        assertTrue(interactMascot.isRightAnswer(mascot, 1));
        assertFalse(interactMascot.isRightAnswer(mascot, 0));
    }

    @Test
    public void testGetAnswers(){
        Mascot mascot = new Mascot("hej");
        List<String> answers = new ArrayList<String>() ;
        answers.add("hej");
        answers.add("tjo");
        InteractMascot interactMascot = new InteractMascot(answers);
        String question = "tjotjo";
        Question forMascot = new Question(question, answers, 1);
        mascot.setQuestion(forMascot);
        assertTrue(interactMascot.getAnswers(mascot).equals(answers));
    }

    @Test
    public void testSettersAndGetters() {
        List<String> answers = new ArrayList<String>() ;
        answers.add("hej");
        answers.add("tjo");
        InteractMascot interactMascot = new InteractMascot(answers);
        assertTrue(interactMascot.getCurrentStringNbr() == 0);
        interactMascot.updateMascotCaught();
        assertTrue(!interactMascot.isMascotCaught());
        interactMascot.setHasAnswered();
        assertTrue(interactMascot.getHasAnswered());
    }
}
