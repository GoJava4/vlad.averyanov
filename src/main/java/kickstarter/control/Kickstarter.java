package kickstarter.control;

import kickstarter.model.dao.Dao;
import kickstarter.view.pages.CategoriesPage;
import kickstarter.view.pages.Page;

public class Kickstarter {

	private DataIOTypeStorage dataIOTypeStorage;
	private Dao genericDao;

	public Kickstarter(DataIOTypeStorage dataIOTypeStorage, Dao genericDao) {
		this.dataIOTypeStorage = dataIOTypeStorage;
		this.genericDao = genericDao;
	}

	public void run() {
		dataIOTypeStorage.getWriter().println("Welcome to Kickstarter developed by Vlad");
		Page currentPage = new CategoriesPage(dataIOTypeStorage, genericDao);
		boolean isExit = false;
		
		while (!isExit) {
			currentPage.showPage();
			currentPage = currentPage.getNextPage();
//			isExit = true;
//			dataIOTypeStorage.getWriter().print("Bye! Have a nice day!");
		}
	}
}
