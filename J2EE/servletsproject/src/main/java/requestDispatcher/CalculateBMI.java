package requestDispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet to Calculate the BMI and send/forward it to another Servlet
@WebServlet(value="/calculate")
public class CalculateBMI extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Fetching the data sent through form
		String height=req.getParameter("height");
		String weight=req.getParameter("weight");
		
		//String to double conversion
		double h=Double.parseDouble(height);
		double w=Double.parseDouble(weight);
		
		//formula to calculate bmi: weight/height*height
		double bmi=w/(h*h);
		
		
		//Storing h,w and bmi in request
		req.setAttribute("height", h);
		req.setAttribute("weight", w);
		req.setAttribute("bmi", bmi);
		
		
		//Sending/Forwarding
		//h,w,bmi values to Result servlet
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("result");
		//url pattern of the Servlet to which 
		//we want to forward the request
		
		dispatcher.forward(req, resp);
	}
}
