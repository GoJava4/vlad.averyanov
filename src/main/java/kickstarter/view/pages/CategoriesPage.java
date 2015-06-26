package kickstarter.view.pages;

import java.util.List;

import kickstarter.control.DataIOTypeStorage;
import kickstarter.entities.Category;
import kickstarter.entities.Quote;
import kickstarter.model.dao.Dao;
import kickstarter.view.Reader;
import kickstarter.view.Writer;

public class CategoriesPage implements Page {

	private List<Category> allCategories;
	private DataIOTypeStorage dataIOTypeStorage;
	private Dao genericDao;

	@Deprecated
	public CategoriesPage(Reader reader, Writer writer, Dao genericDao) {
		this.dataIOTypeStorage = new DataIOTypeStorage(reader, writer);
		this.genericDao = genericDao;
		this.allCategories = genericDao.getAllCategories();
	}

	public CategoriesPage(DataIOTypeStorage dataIOTypeStorage, Dao genericDao) {
		this.dataIOTypeStorage = dataIOTypeStorage;
		this.genericDao = genericDao;
		this.allCategories = genericDao.getAllCategories();
	}

	@Override
	public void showPage() {
		showRandomQuote();
		showAllCategoriesList();
	}

	@Override
	public Page getNextPage(){
		String userInput = dataIOTypeStorage.getReader().readUserInput();
		try {
			int categoryId = Integer.parseInt(userInput);
			for (Category category : allCategories) {
				if (category.getId() == categoryId) {
					return new ProjectsPage(dataIOTypeStorage, genericDao, categoryId);
				}
			}
		} catch (NumberFormatException e) {
			if (userInput.toLowerCase().equals("exit")
					|| userInput.toLowerCase().equals("quit")
					|| userInput.toLowerCase().equals("q")) {
				System.exit(0);
			}
		}
		showErrorDescription();
		return this;
	}

	private void showErrorDescription() {
		dataIOTypeStorage.getWriter().print("Error input. Threre is no such category!\n"
				+ "To exit print q\n");
	}

	private void showAllCategoriesList() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n  Categories\n");
		for (Category category : allCategories) {
			sb.append("<");
			sb.append(category.getId());
			sb.append("> ");
			sb.append(category.getName());
			sb.append("\n");
		}
		dataIOTypeStorage.getWriter().println(sb.toString());
	}

	private void showRandomQuote() {
		dataIOTypeStorage.getWriter().println();
		Quote quote = genericDao.getRandomQuote();
		dataIOTypeStorage.getWriter().println(quote.getQuoteString());
	}

}