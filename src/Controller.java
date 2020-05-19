import java.util.ArrayList;

public class Controller {
    //Creates a blank survey with just a name
    public Survey createBlankSurvey(String name){
        return new Survey(name);
    }

    //Create surveyResponse for survey
    public SurveyResponse createSurveyResponse(SurveyResponse surveyResponse){
        return surveyResponse;
    }

    //Adds one question to a survey at a time
    public Survey addQuestion(String name, Question question){
        Survey survey = new Survey(name);
        survey.addQuestion(question);
        return survey;
    }
    //Adds array of questions to a survey at a time
    public Survey addQuestions(String name, ArrayList<Question> questions){
        Survey survey = new Survey(name);
        survey.setQuestions(questions);
        return survey;
    }

    //Simply returns list of all surveys
    public ArrayList<Survey> getAllSurveys(ArrayList<Survey> surveyList){
        return surveyList;
    }

    //Returns a specific survey by name
    public Survey getSurveyByName(ArrayList<Survey> surveyList, String surveyName){
        Survey survey = null;
        for (Survey survey1: surveyList){
            if (survey1.getName().equals(surveyName)){
                survey = survey1;
            }
        }
        return survey;
    }

    //Find all responses to survey by a survey name
   /* public ArrayList<Integer> getResponseByName(ArrayList<SurveyResponse> responseList, String surveyName){
        for (SurveyResponse response: responseList){
            if (response.getQuestion().){

            }
        }

        return null;
    }

    */
}