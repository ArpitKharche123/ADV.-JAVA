package ServletClasses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(value="/display",loadOnStartup = 1)
public class ServletClass1 extends GenericServlet{
	
	//to check <load-on-startup> working
	@Override
	public void init() throws ServletException {
		System.out.println("ServletClass1 is loaded");
	}
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Service method is called");
		
		PrintWriter printWriter=res.getWriter();
		printWriter.print(
				"<html>"
				+ "<body>"
				+ "<h1>Servlet Class is executed</h1>"
				+ "<h1>Service method is called</h1>"
				+ "</body>"
				+ "</html>"
				);
	}

}
