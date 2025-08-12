package ServletClasses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(value="/info",loadOnStartup = 2)
public class UserInfo extends GenericServlet{
	
	//to check <load-on-startup> working
	@Override
	public void init() throws ServletException {
		System.out.println("UserInfo is loaded");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		//Fetching the values(Form inputs) from the request object
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String age=req.getParameter("age");
		
		//To display information on Web
		PrintWriter printWriter=res.getWriter();
		printWriter.print(
				"<html>"
				+ "<body>"
				+ "<h1>Name: "+name+"</h1>"
				+ "<h1>Email: "+email+"</h1>"
				+ "<h1>Age: "+age+"</h1>"
				+ "</body>"
				+ "</html>"
				
				);
		
	}

}
