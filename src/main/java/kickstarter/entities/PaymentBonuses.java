package kickstarter.entities;

public class PaymentBonuses {

    int id;
    int projectId;
    String bonus;

    public PaymentBonuses(int id, int projectId, String bonus) {
        this.id = id;
        this.projectId = projectId;
        this.bonus = bonus;
    }

    public PaymentBonuses(int projectId, String bonus) {
        this.projectId = projectId;
        this.bonus = bonus;
    }

    public int getId() {
        return id;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getBonus() {
        return bonus;
    }
}
