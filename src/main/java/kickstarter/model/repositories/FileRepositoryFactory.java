package kickstarter.model.repositories;

//import java.io.File;
import java.util.List;

import kickstarter.entities.Category;
import kickstarter.entities.Project;
import kickstarter.entities.Quote;

public class FileRepositoryFactory implements Repository {
	
	//private File file;
	
	FileRepositoryFactory (String factoryType){
		switch (factoryType.toLowerCase()) {
		case "quotes":
			initializeQuotes();
			break;
			
		case "categories":
			initializeCategories();
			break;
			
		case "projects":
			initializeProjects();
			break;

		default:
			break;
		}		
	}

	private void initializeQuotes() {
		// TODO Auto-generated method stub
		
	}

	private void initializeCategories() {
		// TODO Auto-generated method stub
		
	}

	private void initializeProjects() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Quote> getAllQuotes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return null;
	}

}
