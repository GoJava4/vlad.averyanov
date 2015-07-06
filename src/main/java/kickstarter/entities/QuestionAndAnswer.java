package kickstarter.entities;

public class QuestionAndAnswer {

    int id;
    int projectId;
    String question;
    String answer;

    public QuestionAndAnswer(int id, String content, int projectId) {
    }
    
    public QuestionAndAnswer(int id, int projectId, String question) {
        this.id = id;
        this.projectId = projectId;
        this.question = question;
    }

    public QuestionAndAnswer(int projectId, String question) {
        this.projectId = projectId;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
