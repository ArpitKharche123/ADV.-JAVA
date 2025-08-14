package servletcontext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/dbinfo")
public class ServletContextExample extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Creating ServletContext Object
		ServletContext context=getServletContext();
		
		//Fetching the common data from ServletContext Object
		//Data is fetched from web.xml file
		String url=context.getInitParameter("url");
		String username=context.getInitParameter("user");
		String password=context.getInitParameter("password");
		
		System.out.println("URL: "+url);
		System.out.println("Username: "+username);
		System.out.println("Password: "+password);
		
	}
}
