package ServletClasses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/register")
public class Register extends HttpServlet {
	
	//doGet()
	//Data will be visible in URL
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name"),
				email=req.getParameter("email"),
				age=req.getParameter("age");
		
		PrintWriter printWriter=resp.getWriter();
		printWriter.print(
				"<html>"
				+ "<body>"
				+"<h1>doGet() method is Executed</h1><br><br>"
				+ "<h1>Name: "+name+"</h1>"
				+ "<h1>Email: "+email+"</h1>"
				+ "<h1>Age: "+age+"</h1>"
				+ "</body>"
				+ "</html>"
				);
	}
	
	//doPost() : only gets executed when method="post" is present in form tag
	//Data will not be visible in URL (more secured)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name"),
				email=req.getParameter("email"),
				age=req.getParameter("age");
		
		PrintWriter printWriter=resp.getWriter();
		printWriter.print(
				"<html>"
				+ "<body>"
				+"<h1>doPost() method is Executed</h1><br><br>"
				+ "<h1>Name: "+name+"</h1>"
				+ "<h1>Email: "+email+"</h1>"
				+ "<h1>Age: "+age+"</h1>"
				+ "</body>"
				+ "</html>"
				);
	}
}
