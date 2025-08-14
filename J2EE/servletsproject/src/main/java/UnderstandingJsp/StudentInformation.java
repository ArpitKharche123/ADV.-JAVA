package UnderstandingJsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(value="/student")
public class StudentInformation extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Student s=new Student("Namrata","nam@mail.com", 101);
		
		//Exists only for the current request.
		req.setAttribute("student", s);
		
		//or
		
		//Exists across multiple requests from the same client
		HttpSession httpSession=req.getSession();
		httpSession.setAttribute("student", s);
		
		//Redirecting the request to jsp page
		RequestDispatcher dispatcher=req.getRequestDispatcher("studentInfo.jsp");
		dispatcher.forward(req, resp);
	}
}
