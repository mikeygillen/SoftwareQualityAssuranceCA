public class Question {
    private String question;
    private int response;

    public Question() {
    }

    public Question(String question) {
        if (question.equals("")) {
            throw new IllegalArgumentException("BLANK_QUESTION" );
        }
        else {
            this.question = question;
        }
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        if(response < 1 || response > 5) {
            throw new IllegalArgumentException("EXCEED_LIMIT");
        }
        else {
            this.response = response;
        }
    }
}
