import java.util.ArrayList;

public class Survey {
    private String name;
    private ArrayList<Question> questions = new ArrayList<>();

    public Survey(){
    }

    public Survey(String name) {
        this.name = name;
    }

    public Survey(String name, ArrayList<Question> questions) {
        this.name = name;
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
}