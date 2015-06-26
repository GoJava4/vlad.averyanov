package kickstarter.view.pages;

import java.util.List;

import kickstarter.control.DataIOTypeStorage;
import kickstarter.entities.Project;
import kickstarter.model.dao.Dao;

public class ProjectsPage implements Page {

	private DataIOTypeStorage dataIOTypeStorage;
	private int categoryId;
	private List<Project> projectsOfTheCategory;
	private Dao genericDao;	

	public ProjectsPage(DataIOTypeStorage dataIOTypeStorage, Dao genericDao, int categoryId) {
		this.dataIOTypeStorage = dataIOTypeStorage;
		this.genericDao = genericDao;
		this.categoryId = categoryId;
		this.projectsOfTheCategory = genericDao.getAllProjectsOfCategory(categoryId);
	}

	@Override
	public void showPage() {
		showProjectsOfTheCategory();
	}

	private void showProjectsOfTheCategory() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n   Projects of Category ");
		sb.append(genericDao.getCategoryById(categoryId).getName());
		sb.append("\n");
		for (Project project : projectsOfTheCategory) {
			if (project.getCategoryId() == categoryId){
				sb.append("<");
				sb.append(project.getId());
				sb.append("> ");
				sb.append(project.getName());
				sb.append("\n");
			}
		}
		dataIOTypeStorage.getWriter().println(sb.toString());
	}

	@Override
	public Page getNextPage() {
		String userInput = dataIOTypeStorage.getReader().readUserInput();
		try {
			int projectId = Integer.parseInt(userInput);
			for (Project project : projectsOfTheCategory) {
				if (project.getId() == projectId) {
					return new DetailedProjectPage(dataIOTypeStorage, genericDao, project);
				}
			}
		} catch (NumberFormatException e) {
			if (userInput.toLowerCase().equals("q")) {
				System.exit(0);
			} else if (userInput.toLowerCase().equals("prev")){
				return new CategoriesPage(dataIOTypeStorage, genericDao);
			}
		}
		showErrorDescription();
		return this;
	}

	private void showErrorDescription() {
		dataIOTypeStorage.getWriter().println("There is no such project!\n");
	}

}
