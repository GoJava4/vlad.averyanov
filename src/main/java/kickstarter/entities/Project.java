package kickstarter.entities;

import org.joda.time.DateTime;

import javax.persistence.*;

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
	private String shortDescription;
	private int moneyGoal;
	private int pledged;
	private int totalDays;
	private DateTime addingDate;
	private String fullDescription;
	private String link;

	public Project() {
	}


	public Project(int categoryId, String name, String shortDescription, int moneyGoal, int pledged, int totalDays, DateTime addingDate, String fullDescription, String link) {
		this.categoryId = categoryId;
		this.name = name;
		this.shortDescription = shortDescription;
		this.moneyGoal = moneyGoal;
		this.pledged = pledged;
		this.totalDays = totalDays;
		this.addingDate = addingDate;
		this.fullDescription = fullDescription;
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public int getId() {
	    return id;
	}

	public int daysToGo(){
		DateTime daysLeft = DateTime.now().minusMillis((int)addingDate.getMillis());
		return millisInDays(daysLeft.getMillis());
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

	public DateTime getAddingDate() {
		return addingDate;
	}

	public void setName(String name) {
		this.name = name;
	}
}
