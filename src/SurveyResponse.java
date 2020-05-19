import java.util.ArrayList;

public class SurveyResponse {
    private Survey survey;
    private int surveyResponse;
    private ArrayList<Integer> responses = new ArrayList<>();

    public SurveyResponse(){
    }

    public SurveyResponse(Survey survey, int surveyResponse) {
        this.survey = survey;
        this.surveyResponse = surveyResponse;
    }

    public SurveyResponse(Survey survey, ArrayList<Integer> responses) {
        this.survey = survey;
        this.responses = responses;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public int getSurveyResponse() {
        return surveyResponse;
    }

    public void setSurveyResponse(int surveyResponse) {
        this.surveyResponse = surveyResponse;
    }

    public ArrayList<Integer> getResponses() {
        return responses;
    }

    public void setResponses(ArrayList<Integer> responses) {
        this.responses = responses;
    }
}