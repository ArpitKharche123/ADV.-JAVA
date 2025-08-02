package crud;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {
public static void main(String[] args) {

	String url="jdbc:postgresql://localhost/demo";
	String user="postgres";
	String	password="root1234";

	try 
	{
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println("Connnection is established");
		
		 Statement statement = connection.createStatement();
		 
		String query="INSERT INTO employees VALUES(6,'Brijesh','male')";
		
		//statement.execute(query);
		
		//or 
		
		int rows = statement.executeUpdate(query);
		
		System.out.println("Data is inserted successfully!!!");
		System.out.println("No. of rows affected: "+rows);
		
		connection.close();
		statement.close();
	
	}  catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
