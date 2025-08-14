package SessionManagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/contentpage")
public class ContentPage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
			PrintWriter printWriter=resp.getWriter();
			
			//Fetching Session details
			HttpSession httpSession=req.getSession();
			
			//Fetching username value from session object
			String username=(String)httpSession.getAttribute("username");
			
			if(username!=null) {
				printWriter.print("<h1>Welcome to Content Page 1</h1>");
			}else {
				printWriter.print("<h1>Please Login to view Content</h1>"
						+ "<a href=\"SessionLogin.html\">Login</a>");
			}
	}
}
