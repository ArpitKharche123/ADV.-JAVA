package SessionManagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="/logout")
public class Logout extends HttpServlet {
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 HttpSession session = req.getSession();
		
		//Invalidates this session then unbinds any objects bound to it.
		session.invalidate();
		
		PrintWriter printWriter=resp.getWriter();
		printWriter.print(
				"<h1>Logged Out!!</h1>"
				);
}
}
