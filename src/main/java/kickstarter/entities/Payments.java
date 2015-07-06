package kickstarter.entities;

import java.sql.Timestamp;

public class Payments {

    int id;
    int userId;
    double sum;
    Timestamp paymentDate;
    String bank;
    int projectId;

    public Payments(int id, int userId, double sum, Timestamp paymentDate, String bank, int projectId) {
        this.id = id;
        this.userId = userId;
        this.sum = sum;
        this.paymentDate = paymentDate;
        this.bank = bank;
        this.projectId = projectId;
    }

    public Payments(int userId, double sum, Timestamp paymentDate, String bank, int projectId) {
        this.userId = userId;
        this.sum = sum;
        this.paymentDate = paymentDate;
        this.bank = bank;
        this.projectId = projectId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public double getSum() {
        return sum;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public String getBank() {
        return bank;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
