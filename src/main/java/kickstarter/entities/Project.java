package kickstarter.entities;


import kickstarter.model.dao.DAO;
import org.joda.time.DateTime;
import org.joda.time.Days;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	private String name;

	@Column(name = "short_description")
	private String shortDescription;

	@Column(name = "money_goal")
	private int moneyGoal;
	private int pledged;

	@Column(name = "total_days")
	private int totalDays;

	@Column(name = "adding_date")
	private java.sql.Date addingDate;

	@Column(name = "full_description")
	private String fullDescription;
	private String link;

	public Project() {
	}

	public String getName() {
		return name;
	}

	public int getId() {
	    return id;
	}

	public int daysToGo(){
		DateTime dateTime = new DateTime(addingDate);
		return Days.daysBetween(dateTime, DateTime.now()).getDays();
	}

	private int millisInDays(long millis) {
		return (int)millis/(60*60*1000);
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public int getMoneyGoal() {
		return moneyGoal;
	}

	public int getPledged() {
		return pledged;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public String getLink() {
		return link;
	}

	public Date getAddingDate() {
		return addingDate;
	}

	public void setName(String name) {
		this.name = name;
	}
}
