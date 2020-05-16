import java.util.ArrayList;

public class Controller {

    public Survey createSurvey(){
        return new Survey("Test");
    }

    public Survey addQuestion(){
        Survey survey = new Survey("Test");
        ArrayList<String> questions = new ArrayList<>();
        questions.add("This is a question");
        questions.add("This is another question");

        survey.setQuestions(questions);
        return survey;
    }
}