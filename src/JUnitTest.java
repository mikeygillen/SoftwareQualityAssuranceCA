import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class JUnitTest {

    Controller controller = new Controller();

    //Create basic survey with a name
    @Test
    public void createSurvey(){
        assertEquals("TEST", controller.createBlankSurvey("TEST").getName());
    }
    //Create basic surveyResponse linked with a Survey
    /*@Test
    public void createSurveyResponse(){
        ArrayList<String> questions = new ArrayList<>();
        ArrayList<Integer> responses = new ArrayList<>();
        questions.add("Q1"); responses.add(1);
        Survey survey = new Survey("Survey", questions);
        SurveyResponse surveyResponse = new SurveyResponse(survey, responses);

        assertEquals(1, controller.createSurveyResponse(surveyResponse).getResponses());
    }

     */

    //Create a basic question to go along with a survey
    @Test
    public void addQuestion(){
        Question question = new Question("This is a question");
        assertTrue(controller.addQuestion("Test2", question).getQuestions().contains(question));
    }

    //Create an Array of questions to go along with a survey
    @Test
    public void addQuestions(){
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("Q1"));
        questions.add(new Question("Q2"));
        assertEquals(questions, controller.addQuestions("TEST3", questions).getQuestions());
    }

    //Test for empty values. Hoping for false as I input empty Survey name
    @Test
    public void emptySurvey(){
        Survey survey = new Survey("");
        assertEquals(false, controller.validateSurveyName(survey));
    }


    //Test for empty values. Hoping for false as I input empty array of questions
    @Test
    public void emptyQuestion(){
        ArrayList<Question> questions = new ArrayList<>();
        Survey survey = new Survey("Test", questions);
        assertEquals(false, controller.validateBlankQuestion(survey));
    }

    //Test for under 10 questions. Hoping to return false as I have input for 11
    @Test
    public void upperLimit(){
        ArrayList<Question> questions = new ArrayList<>();
        Survey survey = new Survey("Test3");
        for (int i=0; i<11;i++){
            questions.add(new Question(String.valueOf(i)));
        }
        survey.setQuestions(questions);
        assertEquals(false, controller.validateUpperLimit(survey));
    }

    //Prepares list of surveys to be returned by controller
    @Test
    public void getAllSurveys(){
        ArrayList<Survey> surveyList = new ArrayList<>();
        ArrayList<Question> questionList = new ArrayList<>();
        questionList.add(new Question("Q1"));
        questionList.add(new Question("Q2"));
        Survey survey1 = new Survey("Survey1", questionList);
        Survey survey2 = new Survey("Survey2", questionList);

        surveyList.add(survey1); surveyList.add(survey2);

        assertEquals(surveyList, controller.getAllSurveys(surveyList));
    }

    //Searches surveyList for specific survey by name
    @Test
    public void getSurveyByName(){
        ArrayList<Survey> surveyList = new ArrayList<>();
        ArrayList<Question> questionList = new ArrayList<>();
        questionList.add(new Question("Q1"));
        questionList.add(new Question("Q2"));
        questionList.add(new Question("Q3"));
        Survey survey1 = new Survey("Survey1", questionList);
        Survey survey2 = new Survey("Survey2", questionList);
        Survey survey3 = new Survey("Survey3", questionList);

        surveyList.add(survey1); surveyList.add(survey2); surveyList.add(survey3);

        assertEquals(survey2, controller.getSurveyByName(surveyList, "Survey2"));
    }
    //Test to throw error if survey is not in surveyList. Successfully returns null when survey non existent
    @Test
    public void surveyNotFound(){
        ArrayList<Survey> surveyList = new ArrayList<>();
        ArrayList<Question> questionList = new ArrayList<>();
        questionList.add(new Question("Q1"));
        questionList.add(new Question("Q2"));
        Survey survey1 = new Survey("Survey1", questionList);
        Survey survey2 = new Survey("Survey2", questionList);

        surveyList.add(survey1); surveyList.add(survey2);

        assertEquals(null, controller.getSurveyByName(surveyList, "Survey3"));
    }
}