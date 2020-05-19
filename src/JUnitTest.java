import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class JUnitTest {

    Controller controller = new Controller();

    ArrayList<Survey> surveyList = new ArrayList<>();
    ArrayList<Question> questionList = new ArrayList<>();

    Survey survey1 = new Survey("Survey1");
    Survey survey2 = new Survey("Survey2");
    Question Q1 = new Question("Q1");
    Question Q2 = new Question("Q2");

    //Create basic survey with a name
    @Test
    public void createSurvey(){
        assertEquals("TEST", controller.createBlankSurvey("TEST").getName());
    }
    //Create basic surveyResponse
    @Test
    public void createSurveyResponse(){
        questionList.add(Q1); questionList.add(Q2);
        survey1.setQuestions(questionList);

        assertTrue(controller.createSurveyResponse(survey1) instanceof SurveyResponse);
    }

    //Create a basic question to go along with a survey
    @Test
    public void addQuestion(){
        assertTrue(controller.addQuestion("Test2", Q1).getQuestions().contains(Q1));
    }

    //Create an Array of questions to go along with a survey
    @Test
    public void addQuestions(){
        questionList.add(Q1);
        questionList.add(Q2);
        assertEquals(questionList, controller.addQuestions("TEST3", questionList).getQuestions());
    }

    //Test for empty values.
    @Test(expected = IllegalArgumentException.class)
    public void emptySurvey(){
        Survey survey = new Survey();
    }

    //Test for empty values.
    @Test(expected = IllegalArgumentException.class)
    public void emptyQuestion(){
        Question test = new Question("");
        questionList.add(test);
        Survey survey = new Survey("Test", questionList);
    }

    //Test for over 10 questions.
    @Test(expected = IllegalArgumentException.class)
    public void upperLimit(){
        Survey survey = new Survey("Test3");
        for (int i=0; i<11;i++){
            questionList.add(new Question(String.valueOf(i)));
        }
        survey.setQuestions(questionList);
    }

    //Prepares list of surveys to be returned by controller
    @Test
    public void getAllSurveys(){
        questionList.add(Q1); questionList.add(Q2);
        survey1.setQuestions(questionList);
        survey2.setQuestions(questionList);

        surveyList.add(survey1); surveyList.add(survey2);

        assertEquals(surveyList, controller.getAllSurveys(surveyList));
    }

    //Searches surveyList for specific survey by name
    @Test
    public void getSurveyByName(){
        questionList.add(Q1); questionList.add(Q2);
        survey1.setQuestions(questionList);
        survey2.setQuestions(questionList);

        surveyList.add(survey1); surveyList.add(survey2);

        assertEquals(survey2, controller.getSurveyByName(surveyList, "Survey2"));
    }
    //Test to throw error if survey is not in surveyList. Successfully returns null when survey non existent
    @Test
    public void surveyNotFound(){
        questionList.add(Q1); questionList.add(Q2);
        survey1.setQuestions(questionList);
        survey2.setQuestions(questionList);

        surveyList.add(survey1); surveyList.add(survey2);

        assertEquals(null, controller.getSurveyByName(surveyList, "Survey3"));
    }

    //Adding an answer to a SurveyResponse
    @Test
    public void addAnswer(){
        ArrayList<Integer> surveyResponses = new ArrayList<>();
        surveyResponses.add(1); surveyResponses.add(2);

        questionList.add(Q1);
        questionList.add(Q2);
        survey1.setQuestions(questionList);
        SurveyResponse surveyResponse = new SurveyResponse(survey1);
        surveyResponse.setResponses(surveyResponses);

        assertEquals(surveyResponse.getResponses(), controller.addAnswer(survey1, surveyResponses));
    }

    //Return all SurveyResponses for specific Survey
    @Test
    public void getAllResponses(){
        //Populate arrayLists with values
        ArrayList<Integer> answers = new ArrayList<>();
        answers.add(1); answers.add(2); answers.add(3);

        questionList.add(Q1);
        questionList.add(Q2);
        survey1.setQuestions(questionList);
        survey2.setQuestions(questionList);
        surveyList.add(survey1);
        surveyList.add(survey2);

        //Input responses for first surveys questions first
        SurveyResponse surveyResponse = new SurveyResponse(survey1);
        surveyResponse.setResponses(answers);

        //Inputting different responses to second surveys questions now
        SurveyResponse surveyResponse2 = new SurveyResponse(survey2);
        surveyResponse2.addResponse(2); surveyResponse2.addResponse(2); surveyResponse2.addResponse(2);

        //Populate SurveyResponse list with the survey responses
        ArrayList<SurveyResponse> responseList = new ArrayList<>();
        responseList.add(surveyResponse); responseList.add(surveyResponse2);

        //Should return responses for just second list of questions because we search second survey only
        assertEquals(surveyResponse2.getResponses(), controller.getResponseByName(responseList, survey2));
    }
}