package kickstarter.servlets;

//Import required java libraries
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

//Extend HttpServlet class
public class HelloForm extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		
		// Set response content type
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		if ((firstName == null) || (lastName == null)) {
			out.println(getUserAuthForm());
		} else {
			String title = "Using GET Method to Read Form Data";
			out.println(header(title));
			out.println(getProcessedContent(request, title, firstName, lastName));
		}		
	}

	private String getUserAuthForm() {
		StringBuilder sb = new StringBuilder();
		sb.append("<body>");
		sb.append("<form action=\"HelloForm\" method=\"GET\">");
		sb.append("First Name: <input type=\"text\" name=\"first_name\">");
		sb.append("<br />");
		sb.append("Last Name: <input type=\"text\" name=\"last_name\" />");
		sb.append("<input type=\"submit\" value=\"Submit\" />");
		sb.append("</form>");
		sb.append("</body>");
		return sb.toString();
	}

	private String getProcessedContent(HttpServletRequest request, String title, String firstName, String lastName) {
		StringBuilder sb = new StringBuilder();
		sb.append("<body bgcolor=\"#f0f0f0\">\n");
		sb.append("<h1 align=\"center\">");
		sb.append(title); 
		sb.append("</h1>\n<ul>\n"); 
		sb.append("  <li><b>First Name</b>: "); 
		sb.append(firstName); 
		sb.append("\n"); 
		sb.append("  <li><b>Last Name</b>: ");
		sb.append(lastName); 
		sb.append("\n</ul>\n"); 
		sb.append("</body></html>");
		return sb.toString();
	}

	private String header(String title) {
		String header;
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
		header = docType + "<html>\n <head><title>" + title	+ "</title></head>\n";
		return header;
	}
}
