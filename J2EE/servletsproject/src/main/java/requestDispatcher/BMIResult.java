package requestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet to Display Details/Result
@WebServlet(value="/result")
public class BMIResult extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Fetching the data from request came from CalculatorBMI servlet
		double height=(Double)req.getAttribute("height");
		double weight=(Double)req.getAttribute("weight");
		double bmi=(Double)req.getAttribute("bmi");
		
		String result=(bmi<18)?"Underweight":
					(bmi>18 && bmi<=24)?"Normal":
					(bmi>24 && bmi<30)?"Overweight":
					"Obese";
		
		//Displaying information on Web
		PrintWriter printWriter=resp.getWriter();
		printWriter.print(
				"<html>"
				+ "<body>"
				+ "<h2>Height: "+height+"</h2>"
				+ "<h2>Weight: "+weight+"</h2>"
				+ "<h2>bmi: "+bmi+"</h2>"
				+ "<h1>Your BMI result is: "+result+"</h1>"
				+ "</body>"
				+ "</html>"
				);
	}
}
