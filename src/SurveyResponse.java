import java.util.ArrayList;

public class SurveyResponse {

    private String surveyTitle;
    private ArrayList<Question> questions = new ArrayList<>();
    private ArrayList<Integer> responses = new ArrayList<>();

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

    public void addResponses(Integer response) {
            this.responses.add(response);
    }

    public void setResponses(ArrayList<Integer> responses) {
        ArrayList<Integer> answers = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            int value = responses.get(i);
            answers.add(value);
        }
        this.responses = responses;
    }
}