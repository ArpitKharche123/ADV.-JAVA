package crud;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {
public static void main(String[] args) {

	try 
	{
		//Step 1: Load or Register the Driver
		//***Optional Step from Java 6 onwards*** 
		//as Driver is automatically loaded internally!!!
		Class.forName("org.postgresql.Driver");
		
		//or
		
		//***Optional Step from Java 6 onwards*** 
		Driver driver=new org.postgresql.Driver();
		DriverManager.registerDriver(driver);
		
		//Step 2: Establish or open the connection
		
		String url="jdbc:postgresql://localhost:5432/demo";
		//demo is the database name!
		
		String user="postgres";
		String	password="root1234";

		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println("Connnection is established");
		
		//Step 3: Create or Prepare the Statement
		 Statement statement = connection.createStatement();
		 
		String query="INSERT INTO employees VALUES(6,'Brijesh','male')";
		
		//Step 4: Execute the Query 
		
		//statement.execute(query);
		
		//or 
		
		int rows = statement.executeUpdate(query);
		
		System.out.println("Data is inserted successfully!!!");
		System.out.println("No. of rows affected: "+rows);
		
		//Step 5:Close the resources(connection and statement)
		//Optional but highly recommended!!
		//Done automatically by compiler when try-resource is used!!
		connection.close();
		statement.close();
		
		//Step 6:De-register the Driver if Registered(Optional)
		//DriverManager.deregisterDriver(driver);
	
	}  catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	//Only required if Step 1 is Executed!!!
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
