import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JUnitTest {

    Controller controller = new Controller();

    @Test
    public void createSurvey(){
        assertEquals("Test", controller.createSurvey().getName());
    }

    @Test
    public void addQuestion(){
        ArrayList<String> questions = new ArrayList<>();
        questions.add("This is a question");
        questions.add("This is another question");
        assertEquals(true, controller.addQuestion().getQuestions().equals(questions));
    }
}