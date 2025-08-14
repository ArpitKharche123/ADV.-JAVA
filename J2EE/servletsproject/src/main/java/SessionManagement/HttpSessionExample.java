package SessionManagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class UserDetails{
	String firstName,lastName,email,gender;
	long phone;
	public UserDetails(String firstName, String lastName, String email, String gender, long phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
	}
}

@WebServlet(value="/session")
public class HttpSessionExample extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Creating HttpSession Object
		//This object will hold some data,
		//Which can be accessed by Server
		HttpSession session = req.getSession();
		
		//Saving data in session object
		session.setAttribute("username", "Vish@xyz");
		session.setAttribute("id", "E123");
		
		//Saving data in form of Object in Session
		session.setAttribute("user_details",
				new UserDetails(
				"Vishwas","Reddy",
				"xyz@mail.com","male", 9809898023l));
		
		
		//Fetching the data from session object
		String username =(String)session.getAttribute
				("username"),
				id=(String)session.getAttribute("id");
		
		UserDetails userDetails=(UserDetails)session
				.getAttribute("user_details");
		
		resp.getWriter().print(
				"<html>"
				+"<body>"
				+"<h1>User Details: </h1><br>"
				+"<h1>Username : "+username+"</h1>"
				+"<h1>Id : "+id+"</h1>"
				+"<h1>First Name : "+userDetails.firstName+"</h1>"
				+"<h1>Last Name : "+userDetails.lastName+"</h1>"
				+"<h1>Email : "+userDetails.email+"</h1>"
				+"<h1>Gender : "+userDetails.gender+"</h1>"
				+"<h1>Phone : "+userDetails.phone+"</h1>"
				+"</body>"
				+"</html>"
				);
	}
}
