package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class delete {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/demo";
		String user="postgres";
		String	password="root1234";
		
		try {
			
		Connection connection = DriverManager.getConnection(url, user, password);
		
		System.out.println("Connnection is established");
		
		Statement statement = connection.createStatement();

		String query="DELETE FROM employees "
				+ "WHERE id=4";
		
		//statement.executeUpdate(query);
		
		//or
		
		statement.execute(query);
		System.out.println("Data is deleted successfully!!!");
		
		connection.close();
		statement.close();
		
		
	}  catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
