package kickstarter.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quotes")
public class Quote {

	@Id
	@GeneratedValue
	private Integer id;
	private String content;
	private String author;

	public Quote() {
	}

	public Quote(String content, String author) {
		this.content = content;
		this.author = author;
	}

	public Quote(int id, String content, String author) {
		this.id = id;
		this.content = content;
		this.author = author;
	}

	public Integer getId() {
		return id;
	}

	public String getQuoteString() {
		return ("\"" + content + "\" " + author);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}