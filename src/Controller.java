import org.junit.internal.ArrayComparisonFailure;

import java.util.ArrayList;

public class Controller {
    //Creates a blank survey with just a name
    public Survey createBlankSurvey(String name){
        return new Survey(name);
    }

    //Create surveyResponse for survey
    public SurveyResponse createSurveyResponse(Survey survey){
        SurveyResponse surveyResponse = new SurveyResponse(survey);
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

    //Add an answer to a surveyResponse
    public ArrayList<Integer> addAnswer(Survey survey, ArrayList<Integer> answers){
        SurveyResponse surveyResponse = new SurveyResponse(survey);
        surveyResponse.setResponses(answers);
        return surveyResponse.getResponses();
    }

    //Find all responses to survey by a survey name
    public SurveyResponse getResponseByName(ArrayList<SurveyResponse> responseList, Survey survey){
        SurveyResponse response = null;
        String name = survey.getName();

        for (SurveyResponse answer: responseList){
            if (answer.getSurveyTitle().equals(name)){
                response = answer;
            }
        }
        return response;
    }

    //Get average response of a survey
    public double getAverageSurvey(SurveyResponse surveyResponse){
        int questions = surveyResponse.getQuestions().size();
        double sum = getSum(surveyResponse.getResponses());
        double average = sum/questions;
        return average;
    }

    //Get Standard deviation of a survey
    public double getStandardDeviation(SurveyResponse surveyResponse){
        return calculateSD(surveyResponse.getResponses());
    }

    public double getSum(ArrayList<Integer> dataSet){
        int sum = 0;
        for (int i : dataSet) {
            sum += i;
        }
        return sum;
    }
    public double calculateSD(ArrayList<Integer> dataSet)
    {
        double sum = getSum(dataSet), standardDeviation = 0.0;
        int length = dataSet.size();

        for(double num : dataSet) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: dataSet) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
    }
}