package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class update {

	public static void main(String[] args) {
		
		String url="jdbc:postgresql://localhost:5432/demo";
		String user="postgres";
		String	password="root1234";
		
		try {
			
		Connection connection = DriverManager.getConnection(url, user, password);
		
		System.out.println("Connnection is established");
		
		//Step 3:Create or Prepare the Statement
		
		Statement statement = connection.createStatement();
		
		//Step 4:Execute the query
		String query="UPDATE employees "
				+ "SET name='Emily',gender='female' "
				+ "WHERE ID=1";
		
		statement.execute(query);
		System.out.println("Data is updated successfully!!!");
		
		//Step 5: Close the connection
		connection.close();
		statement.close();
		
		//Step 6:De-register the Driver if Registered
		//DriverManager.deregisterDriver(driver);
		
	}  catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
