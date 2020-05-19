import java.util.ArrayList;

public class SurveyResponse {

    private Survey survey;
    private String surveyTitle;
    private ArrayList<Question> questions = new ArrayList<>();
    private ArrayList<Integer> responses = new ArrayList<>();

    public SurveyResponse(){
    }

    public SurveyResponse(Survey survey) {
        this.surveyTitle = survey.getName();
        this.questions = survey.getQuestions();
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Integer> getResponses() {
            for(Question question : this.questions) {
                int value = question.getResponse();
                responses.add(value);
            }
            return responses;
        }
}