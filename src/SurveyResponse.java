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

    public String getSurveyTitle() {
        return surveyTitle;
    }

    public ArrayList<Integer> getResponses() {
            return responses;
        }

    public void setResponses(ArrayList<Integer> responses) {
        if (responses.size() != this.questions.size()){
            throw new IllegalArgumentException("UNANSWERED_QUESTION" );
        }else {
            for(int i=0; i<questions.size();i++) {
                int value = questions.get(i).getResponse();
                responses.add(value);
            }
            this.responses = responses;
        }
    }
}