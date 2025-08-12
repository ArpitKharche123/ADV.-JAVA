package requestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/login")
public class UserLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Fetching username and password
		//given while filling login form
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		PrintWriter printWriter=resp.getWriter();
		
		if(username.equals("admin") && password.equals("admin123")) {
			printWriter.print(
					"<html>"
					+ "<body>"
					+ "<h1>Login Successful!!!</h1>"
					+ "</body>"
					+ "</html>"
					);
			
			//Can be used to redirect to any page when login is successful
			resp.sendRedirect("index.jsp");
		}
		else {
			printWriter.print(
					"<html>"
					+ "<body>"
					+ "<h1>Login Failed!! Try Again</h1>"
					+ "</body>"
					+ "</html>"
					);
			
			//to display login form again in login failed
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		}
	}
}
