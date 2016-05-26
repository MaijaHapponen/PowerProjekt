package test;
import com.crap.game.model.Mascot;
import com.crap.game.model.Question;
import com.crap.game.model.Questions;
import org.junit.Test;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Arrays;
import java.util.List;
=======
>>>>>>> 8d0f5a4e66b2e2486ad51be9502bd22ae891ca7d

import static org.junit.Assert.*;
/**
 * Created by rebeccafinne on 16-05-24.
 */
public class QuestionsTest {

    @Test
    public void testSetQuestions(){
        Mascot mascot = new Mascot("luckyluke");
        String theQuestion = "What is Lucky Lukes \n horse called?";
        List<String> answers = new ArrayList<String>();
        answers.add("Holly Hunter");
        answers.add("Betty Bowler");
        answers.add("Randy Runner");
        answers.add("Jolly Jumper");

        Question questions = new Question(theQuestion, answers, 3);
        mascot.setQuestion(questions);
        assertTrue(mascot.getQuestion().getQuestion().equals("What is Lucky Lukes \n horse called?"));
        assertTrue(mascot.getQuestion().getAlternatives().get(1).equals("Betty Bowler"));
        assertTrue(mascot.getQuestion().getCorrectAnswer() == 3);

    }

}