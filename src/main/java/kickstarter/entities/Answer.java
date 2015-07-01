package kickstarter.entities;

public class Answer {

    int id;
    int questionId;
    String context;

    public Answer(int id, int questionId, String context) {
        this.id = id;
        this.questionId = questionId;
        this.context = context;
    }

    public int getId() {
        return id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
