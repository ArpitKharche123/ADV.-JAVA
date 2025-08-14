package servletConfig;

import java.io.IOException;
import java.net.http.HttpClient;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Pi=3.142 is the data related to Circle Servlet only!!!
@WebServlet(value="/circle",
		initParams = {
				@WebInitParam(name="PI",value="3.142")
		}
		)
public class Circle extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Fetching ServletConfig Object
		ServletConfig servletConfig=getServletConfig();
		
		//Fetching value of PI, present in ServletConfig Object
		String pi=servletConfig.getInitParameter("PI");
		
		System.out.println("PI: "+pi);
		
		
	}
}
