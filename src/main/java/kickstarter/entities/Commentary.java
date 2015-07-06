package kickstarter.entities;

public class Commentary {

    int id;
    int projectId;
    String content;

    public Commentary(int id, int projectId, String content) {
        this.id = id;
        this.projectId = projectId;
        this.content = content;
    }

    public Commentary(int projectId, String content) {
        this.projectId = projectId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getContent() {
        return content;
    }
}
