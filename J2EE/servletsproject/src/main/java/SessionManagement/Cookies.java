package SessionManagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/addcookie")
public class Cookies extends HttpServlet {
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	  //Creating 2 cookie objects
		Cookie cookie=new Cookie("Username","admin"),
			   cookie2=new Cookie("Password","xyz123");
		
		//Adding cookie objects to response object
		resp.addCookie(cookie);
		resp.addCookie(cookie2);
		
		PrintWriter printWriter= resp.getWriter();
		printWriter.print(
				"<html>"
				+"<body>"
				+"<h1>"
				+ cookie.getName()+" : "+cookie.getValue()
				+"<br>"
				+cookie2.getName()+" : "+cookie2.getValue()
				+ "</h1>"
				+"</body>"
				+"</html>"
				);
		
		System.out.println("Cookie is created and added on response!!");
	
		
		//Setting lifetime of cookie
			cookie.setMaxAge(60);
			//cookie will expire in 1 minute 
			cookie2.setMaxAge(5*24*60*60);//5 days
			
			//Setting value for a cookie
			//Spaces are not allowed!!!
			cookie.setValue("Michael");
				
		//Expiring/Destroying a cookie
			cookie.setMaxAge(0);
		
}
}
