package kickstarter.entities;

public class Quote {

	private Integer id;
	private String content;
	private String author;

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