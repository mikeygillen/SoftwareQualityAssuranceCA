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
        questionList.clear();
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
        ArrayList<Integer> answers  = new ArrayList<>();
        answers.add(1); answers.add(2);
        ArrayList<Integer> answers2  = new ArrayList<>();
        answers2.add(4); answers2.add(4);

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
        surveyResponse2.setResponses(answers2);

        //Populate SurveyResponse list with the survey responses
        ArrayList<SurveyResponse> responseList = new ArrayList<>();
        responseList.add(surveyResponse); responseList.add(surveyResponse2);

        //Should return responses for just second list of questions because we search first survey only
        assertEquals(surveyResponse, controller.getResponseByName(responseList, survey1));
    }

    //Return the average of the responses for a Survey
    @Test
    public void getAverageSurvey(){
        //Populate arrayLists with values
        ArrayList<Integer> answers  = new ArrayList<>();
        answers.add(1); answers.add(2);
        ArrayList<Integer> answers2  = new ArrayList<>();
        answers2.add(4); answers2.add(4);

        questionList.add(Q1);
        questionList.add(Q2);
        survey1.setQuestions(questionList);

        //Input responses for surveys question answers
        SurveyResponse surveyResponse = new SurveyResponse(survey1);
        surveyResponse.setQuestions(questionList);
        surveyResponse.setResponses(answers);
        surveyResponse.setResponses(answers2);

        //Test to get Average
        assertEquals(4, controller.getAverageSurvey(surveyResponse) ,1e-3);
    }

    //Standard Deviation for Survey
    @Test
    public void getStandardDeviation(){
        //Populate arrayLists with values
        ArrayList<Integer> answers  = new ArrayList<>();
        answers.add(1); answers.add(2);

        questionList.add(Q1);
        questionList.add(Q2);
        survey1.setQuestions(questionList);

        //Input responses for surveys question answers
        SurveyResponse surveyResponse = new SurveyResponse(survey1);
        surveyResponse.setQuestions(questionList);
        surveyResponse.setResponses(answers);
        surveyResponse.addResponses(2); surveyResponse.addResponses(2); surveyResponse.addResponses(3);

        //I hardcoded in this value as I know it to be the correct standard deviation for the above numbers used.
        assertEquals(2.0976176963403033 , controller.getStandardDeviation(surveyResponse)  ,1e-3);
    }

    //Get the max survey response value
    @Test
    public void getMax(){
        //Populate arrayLists with values
        ArrayList<Integer> answers  = new ArrayList<>();
        answers.add(1); answers.add(2);

        questionList.add(Q1);
        questionList.add(Q2);
        survey1.setQuestions(questionList);

        //Input responses for surveys question answers
        SurveyResponse surveyResponse = new SurveyResponse(survey1);
        surveyResponse.setQuestions(questionList);
        surveyResponse.setResponses(answers);

        //Test to get maxValue
        assertEquals(2 , controller.getMaxSurvey(surveyResponse), 1e-3);

    }

    //Get the min survey response value
    @Test
    public void getMin(){
        //Populate arrayLists with values
        ArrayList<Integer> answers  = new ArrayList<>();
        answers.add(1); answers.add(2);

        questionList.add(Q1);
        questionList.add(Q2);
        survey1.setQuestions(questionList);

        //Input responses for surveys question answers
        SurveyResponse surveyResponse = new SurveyResponse(survey1);
        surveyResponse.setQuestions(questionList);
        surveyResponse.setResponses(answers);

        //Test to get maxValue
        assertEquals(1 , controller.getMinSurvey(surveyResponse), 1e-3);
    }

    //Return the average of the responses for a Survey
    @Test
    public void getAverageSpecificSurvey(){
        //Populate arrayLists with values
        ArrayList<Integer> answers  = new ArrayList<>();
        answers.add(1); answers.add(2);
        ArrayList<Integer> answers2  = new ArrayList<>();
        answers2.add(4); answers2.add(4);

        questionList.add(Q1);
        questionList.add(Q2);
        survey1.setQuestions(questionList);

        //Input responses for surveys question answers
        ArrayList<SurveyResponse> surveyResponses = new ArrayList<>();
        SurveyResponse surveyResponse = new SurveyResponse(survey1);
        SurveyResponse surveyResponse1 = new SurveyResponse(survey1);
        surveyResponse.setQuestions(questionList);
        surveyResponse1.setQuestions(questionList);
        surveyResponse.setResponses(answers);
        surveyResponse1.setResponses(answers2);

        //Test to get Average
        assertEquals(1, controller.getAverageSpecificSurvey(surveyResponses, Q1) ,1e-3);
    }

    //Standard Deviation for Survey
    @Test
    public void getSpecificStandardDeviation(){
        //Populate arrayLists with values
        ArrayList<Integer> answers  = new ArrayList<>();
        answers.add(1); answers.add(2);
        ArrayList<Integer> answers2  = new ArrayList<>();
        answers2.add(4); answers2.add(4);

        questionList.add(Q1);
        questionList.add(Q2);
        survey1.setQuestions(questionList);

        //Input responses for surveys question answers
        ArrayList<SurveyResponse> surveyResponses = new ArrayList<>();
        SurveyResponse surveyResponse = new SurveyResponse(survey1);
        SurveyResponse surveyResponse1 = new SurveyResponse(survey1);
        surveyResponse.setQuestions(questionList);
        surveyResponse1.setQuestions(questionList);
        surveyResponse.setResponses(answers);
        surveyResponse1.setResponses(answers2);


        //I hardcoded in this value as I know it to be the correct standard deviation for the above numbers used.
        assertEquals(0, controller.getSpecificStandardDeviation(surveyResponses, Q1)  ,1e-3);
    }

    //Get the max survey response value
    @Test
    public void getSpecificMax(){
        //Populate arrayLists with values
        ArrayList<Integer> answers  = new ArrayList<>();
        answers.add(1); answers.add(2);
        ArrayList<Integer> answers2  = new ArrayList<>();
        answers2.add(4); answers2.add(4);

        questionList.add(Q1);
        questionList.add(Q2);
        survey1.setQuestions(questionList);

        //Input responses for surveys question answers
        ArrayList<SurveyResponse> surveyResponses = new ArrayList<>();
        SurveyResponse surveyResponse = new SurveyResponse(survey1);
        SurveyResponse surveyResponse1 = new SurveyResponse(survey1);
        surveyResponse.setQuestions(questionList);
        surveyResponse1.setQuestions(questionList);
        surveyResponse.setResponses(answers);
        surveyResponse1.setResponses(answers2);

        //Test to get maxValue
        assertEquals(0 , controller.getSpecificMax(surveyResponses, Q1), 1e-3);

    }

    //Get the min survey response value
    @Test
    public void getSpecificMin(){
        //Populate arrayLists with values
        ArrayList<Integer> answers  = new ArrayList<>();
        answers.add(1); answers.add(2);
        ArrayList<Integer> answers2  = new ArrayList<>();
        answers2.add(4); answers2.add(4);

        questionList.add(Q1);
        questionList.add(Q2);
        survey1.setQuestions(questionList);

        //Input responses for surveys question answers
        ArrayList<SurveyResponse> surveyResponses = new ArrayList<>();
        SurveyResponse surveyResponse = new SurveyResponse(survey1);
        SurveyResponse surveyResponse1 = new SurveyResponse(survey1);
        surveyResponse.setQuestions(questionList);
        surveyResponse1.setQuestions(questionList);
        surveyResponse.setResponses(answers);
        surveyResponse1.setResponses(answers2);

        //Test to get maxValue
        assertEquals(0 , controller.getSpecificMin(surveyResponses, Q1), 1e-3);
    }
}