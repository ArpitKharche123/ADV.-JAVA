package SessionManagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="/session-a")
public class SessionA extends HttpServlet {
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 PrintWriter writer = resp.getWriter();
		
		//Fetching login details from Form
		String enteredUsername=req.getParameter("user_name"),
				enteredPassword=req.getParameter("password");
		
		//Fetching user and password from web.xml 
		ServletContext context=getServletContext();
		
		String username=context.getInitParameter("Username");
		String password=context.getInitParameter("Password");
		
		//Comparing entered details with actual details
		if(enteredUsername.equals(username) &&
			enteredPassword.equals(password)){
			
			//Creating HttpSession Object only when credentials match
			writer.print("<h1>Login Success!!</h1>"
					+"<a href=\"contentpage\">View Content</a><br><br>"
					+"<a href=\"logout\">Logout</a>"
					);
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
		}
		else {
			writer.print("<h1>Login Failed!!</h1>"
					+"<a href=\"SessionLogin.html\">Try Again</a>");
		}
		
		
}
}
