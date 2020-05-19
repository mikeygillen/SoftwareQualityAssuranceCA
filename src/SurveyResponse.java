import java.util.ArrayList;

public class SurveyResponse {

    private Survey name;
    private ArrayList<Question> questions = new ArrayList<>();
    private ArrayList<Integer> responses = new ArrayList<>();

    public SurveyResponse(){
    }

    public SurveyResponse(Survey name, ArrayList<Question> questions) {
        this.name = name;
        this.questions = questions;
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