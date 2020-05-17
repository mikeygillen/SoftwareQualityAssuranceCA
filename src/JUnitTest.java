import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JUnitTest {

    Controller controller = new Controller();

    //Create basic survey with a name
    @Test
    public void createSurvey(){
        assertEquals("TEST", controller.createSurvey("TEST").getName());
    }

    //Create a basic question to go along with a survey
    @Test
    public void addQuestion(){
        ArrayList<String> questions = new ArrayList<>();
        questions.add("Q1"); questions.add("Q2");
        assertEquals(questions, controller.addQuestion("TEST2", questions).getQuestions());
    }

    //Test for empty values. Hoping for false as i input empty String for name
    @Test
    public void emptySurvey(){
        Survey survey = new Survey("");
        assertEquals(false, controller.validateSurveyName(survey));
    }


    //Test for empty values. Hoping for false as i input empty array of questions
    @Test
    public void emptyQuestion(){
        ArrayList<String> questions = new ArrayList<>();
        Survey survey = new Survey("Test", questions);
        assertEquals(false, controller.validateBlankQuestion(survey));
    }

    //Test for under 10 questions. Hoping to return false as i will input over 11
    @Test
    public void upperLimit(){
        ArrayList<String> questions = new ArrayList<>();
        Survey survey = new Survey("Test3");
        for (int i=0; i<11;i++){
            questions.add(String.valueOf(i));
        }
        survey.setQuestions(questions);
        assertEquals(false, controller.validateUpperLimit(survey));
    }
}