package kickstarter.model.repositories;

import java.util.List;

import kickstarter.entities.Quote;
import kickstarter.entities.Category;
import kickstarter.entities.Project;

public interface Repository {

	List<Quote> getAllQuotes();

	List<Category> getAllCategories();

	List<Project> getAllProjects();

}
