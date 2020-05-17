import java.util.ArrayList;

public class Survey {
    private String name;
    private ArrayList<String> questions;

    public Survey(){
    }

    public Survey(String name) {
        this.name = name;
    }

    public Survey(String name, ArrayList<String> questions) {
        this.name = name;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }
}