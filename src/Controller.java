import java.util.ArrayList;

public class Controller {

    public Survey createSurvey(String name){
        return new Survey(name);
    }

    public Survey addQuestion(String name, ArrayList<String> questions){
        Survey survey = new Survey(name);
        survey.setQuestions(questions);
        return survey;
    }

    public boolean validateSurveyName(Survey survey) {
        if (survey.getName().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validateBlankQuestion(Survey survey) {
        if (survey.getQuestions().isEmpty()){
            return false;
        } else {
            return true;
        }
    }

    public boolean validateUpperLimit(Survey survey) {
        if (survey.getQuestions().size() > 10){
            return false;
        }else {
            return true;
        }
    }
}