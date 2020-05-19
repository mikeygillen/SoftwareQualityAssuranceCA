import java.util.ArrayList;

public class SurveyResponse {
    private Question question;
    private ArrayList<Integer> responses = new ArrayList<>();

    public SurveyResponse(){
    }

    public SurveyResponse(Question question, ArrayList<Integer> responses) {
        this.question = question;
        this.responses = responses;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void addResponse(Integer response) {
        this.responses.add(response);
    }
    public ArrayList<Integer> getResponses() {
        return responses;
    }

    public void setResponses(ArrayList<Integer> responses) {
        this.responses = responses;
    }
}