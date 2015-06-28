package kickstarter.servlets;

import kickstarter.model.dao.Dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoriesServlet extends HttpServlet{

	Dao dao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(req.getParameterMap().toString());
		req.setAttribute("quote", dao.getRandomQuote());
		req.setAttribute("listOfCategories", dao.getAllCategories());
		req.getRequestDispatcher("jsp/categories.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Why to call doPost here?");
		System.out.println("Your req.getParameterMap().toString() is:"+req.getParameterMap().toString());
	}

}
