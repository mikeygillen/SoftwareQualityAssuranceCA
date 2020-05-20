public class Question {
    private String question;
    private int response;

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

    public int getResponse() {
        return response;
    }

}
