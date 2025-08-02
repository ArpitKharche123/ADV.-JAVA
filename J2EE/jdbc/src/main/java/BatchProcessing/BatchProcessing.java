package BatchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchProcessing {

	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/demo?user=postgres&password=root1234");) {
			
			String query="INSERT INTO employees VALUES (?,?,?)";
			
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			Scanner scanner=new Scanner(System.in);
			char choice;
			do {
				
				//Asking the values from user 
				//and setting those values to placeholders(?)
				System.out.println("Enter the id: ");
				int id= scanner.nextInt();
				preparedStatement.setInt(1,id);
				
				scanner.nextLine();
				
				System.out.println("Enter the name: ");
				String name=scanner.nextLine();
				preparedStatement.setString(2, name);
				
				System.out.println("Enter the gender: ");
				String gender=scanner.nextLine();
				preparedStatement.setString(3, gender);
				
				//adding the query to the batch
				preparedStatement.addBatch();
				
				System.out.println("Do you want to add more employees?(y/n)");
				 choice=scanner.next().charAt(0);
				
			}while(choice=='y');
			
			int[] executeBatch = preparedStatement.executeBatch();
			
			System.out.println("Batch is executed!!!");
			System.out.println(executeBatch.length+" employees are added!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
