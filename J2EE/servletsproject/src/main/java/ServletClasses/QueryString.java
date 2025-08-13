package ServletClasses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/query")
public class QueryString extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Fetching the data from query string(url given in href attribute)
		String name=req.getParameter("name"),
				email=req.getParameter("email"),
				age=req.getParameter("age");
		
		PrintWriter printWriter=resp.getWriter();
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
