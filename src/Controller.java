import java.util.ArrayList;

public class Controller {
    //Creates a blank survey with just a name
    public Survey createBlankSurvey(String name){
        return new Survey(name);
    }

    //Adds one question to a survey at a time
    public Survey addQuestion(String name, String question){
        Survey survey = new Survey(name);
        survey.addQuestion(question);
        return survey;
    }
    //Adds array of questions to a survey at a time
    public Survey addQuestions(String name, ArrayList<String> questions){
        Survey survey = new Survey(name);
        survey.setQuestions(questions);
        return survey;
    }

    //Validate that survey name is not blank
    public boolean validateSurveyName(Survey survey) {
        if (survey.getName().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    //Validate that survey questions are not blank
    public boolean validateBlankQuestion(Survey survey) {
        if (survey.getQuestions().isEmpty()){
            return false;
        } else {
            return true;
        }
    }
    //Validate that survey questions do not exceed 10
    public boolean validateUpperLimit(Survey survey) {
        if (survey.getQuestions().size() > 10){
            return false;
        }else {
            return true;
        }
    }

    //Simply returns list of all surveys
    public ArrayList<Survey> getAllSurveys(ArrayList<Survey> surveyList){
        return surveyList;
    }
}