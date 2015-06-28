package kickstarter.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import kickstarter.model.dao.Dao;
import kickstarter.entities.Quote;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class HelloWorld extends HttpServlet {
	@Autowired
	Dao genericDao;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "Hello World --";
		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1><br/>");
		
		Quote quote = genericDao.getRandomQuote();
		out.println("<h1>" + quote.getQuoteString() + "</h1>");
		System.out.println( quote.getQuoteString());
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

}
