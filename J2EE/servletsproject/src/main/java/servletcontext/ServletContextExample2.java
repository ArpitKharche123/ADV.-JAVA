package servletcontext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/commonobj")
public class ServletContextExample2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//Object Creation of DbInfo class
		//This object will act as common object for all the Servlet Classes
		
		DbInfo dbInfo=new DbInfo("jdbc:postgresql://localhost/Db","postgres","root1234");
		
		//Creating ServletContext Object
		//This Object will hold the data which is common to all the Servlet Classes
		
		ServletContext context=getServletContext();
		
		//Adding DbInfo object into ServletContext Object
		context.setAttribute("dbinfo", dbInfo);
		
		//Fetching the object present in ServletContext Object
		 DbInfo info=(DbInfo)context.getAttribute("dbinfo");
		 
		 //Printing the data present in DbInfo Object
		 System.out.println("URL: "+info.url);
		 System.out.println("Username: "+info.user);
		 System.out.println("Password: "+info.password);
		 
		
		
		
		
	}
}
