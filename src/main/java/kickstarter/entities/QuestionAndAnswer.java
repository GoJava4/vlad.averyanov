package kickstarter.entities;

public class QuestionAndAnswer {

    int id;
    int projectId;
    String content;

    public QuestionAndAnswer(int id, String content, int projectId) {
        this.id = id;
        this.content = content;
        this.projectId = projectId;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNotAssigned(){
        return (projectId<=0);
    }
}
