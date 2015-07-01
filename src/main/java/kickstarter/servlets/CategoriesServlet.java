package kickstarter.servlets;

import kickstarter.entities.Quote;
import kickstarter.model.services.CategoryService;
import kickstarter.model.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoriesServlet extends SpringInitedServlet {

	@Autowired
	QuoteService quoteService;

	@Autowired
	CategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			Quote quote = quoteService.getRandomQuote();
			req.setAttribute("quote", quote.getQuoteString());
			req.setAttribute("listOfCategories", categoryService.getAllCategories());
			req.getRequestDispatcher("jsp/categories.jsp").forward(req, resp);
	}

	private void showError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("jsp/error-404.jsp").forward(req, resp);
		System.out.println("ERROR no quotes");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Why to call doPost here?");
		System.out.println("Your req.getParameterMap().toString() is:"+req.getParameterMap().toString());
	}

}
