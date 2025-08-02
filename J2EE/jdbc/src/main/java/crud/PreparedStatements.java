package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatements {

	public static void main(String[] args) {
		
		try {

			String url="jdbc:postgresql://localhost:5432/demo";
			String user="postgres";
			String	password="root1234";
			
			Connection connection = DriverManager.getConnection(url, user, password);
			
			System.out.println("Connnection is established");
			
			//Dynamic Query
			String query="INSERT INTO employees VALUES(?,?,?)";
			// ? are considered as placeholders
			
			PreparedStatement statement = connection.prepareStatement(query);

			Scanner scanner=new Scanner(System.in);
			
			//Setting the values for placeholders(?)
			System.out.println("Enter the id : ");
			int id=scanner.nextInt();
			statement.setInt(1, id);
			scanner.nextLine();
			System.out.println("Enter the name: ");
			String name=scanner.nextLine();
			statement.setString(2, name);
			System.out.println("enter the gender: ");
			String gender=scanner.nextLine();
			statement.setString(3, gender);
			
			
			statement.execute();
			System.out.println("Employee added successfully!!!");
			
	
			connection.close();
			
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
