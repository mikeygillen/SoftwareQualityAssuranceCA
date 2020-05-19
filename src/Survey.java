import java.util.ArrayList;

public class Survey {
    private String name;
    private ArrayList<Question> questions = new ArrayList<>();

    public Survey(){
        throw new IllegalArgumentException("BLANK_SURVEY" );
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
        if(questions.size() < 1 || questions.size() > 10) {
            throw new IllegalArgumentException("EXCEED_LIMITS");
        }
        else {
            this.questions = questions;
        }
    }
}