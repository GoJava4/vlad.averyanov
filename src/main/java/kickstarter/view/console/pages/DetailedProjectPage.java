package kickstarter.view.console.pages;

import kickstarter.control.console.DataIOTypeStorage;
import kickstarter.entities.Project;
import kickstarter.model.dao.Dao;

public class DetailedProjectPage implements Page {

	private DataIOTypeStorage dataIOTypeStorage;
	private Project project;
	private Dao genericDao;

	public DetailedProjectPage(DataIOTypeStorage dataIOTypeStorage, Dao genericDao, 
			Project project) {
		this.dataIOTypeStorage = dataIOTypeStorage;
		this.genericDao = genericDao;
		this.project = project;
	}

	@Override
	public void showPage() {
		showDetailedDescription();
	}

	private void showDetailedDescription() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n   Project " + project.getName());
		sb.append(project.getFullDescription());
		dataIOTypeStorage.getWriter().println(sb.toString());	
	}

	@Override
	public Page getNextPage() {
		String userInput = dataIOTypeStorage.getReader().readUserInput();
		if (userInput.toLowerCase().equals("q")) {
			System.exit(0);
		} else if (userInput.toLowerCase().equals("prev")) {
			return new ProjectsPage(dataIOTypeStorage, genericDao, project.getCategoryId());
		}
		showErrorDescription();
		return this;
	}

	private void showErrorDescription() {
		dataIOTypeStorage.getWriter().println("You can only return back to the category (prev) "
				+ "or exit program (q)");		
	}

}
