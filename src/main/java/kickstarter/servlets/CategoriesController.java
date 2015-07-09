package kickstarter.servlets;

import kickstarter.entities.Quote;
import kickstarter.model.services.CategoryService;
import kickstarter.model.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("/categories")
public class CategoriesController {

	@Autowired
	QuoteService quoteService;

	@Autowired
	CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public String showCategories(ModelMap model)
			throws ServletException, IOException {
		Quote quote = quoteService.getRandomQuote();
		model.addAttribute("quote", quote.getQuoteString());
		model.addAttribute("listOfCategories", categoryService.getAllCategories());
		return "categories.jsp";
	}
}
