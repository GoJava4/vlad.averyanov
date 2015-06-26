package kickstarter.control;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import kickstarter.model.dao.Dao;
import kickstarter.entities.Quote;

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
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		final AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);
	}

}
