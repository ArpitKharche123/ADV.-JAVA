package CallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallingStoredProcedures {

	public static void main(String[] args) {
		try(Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost/demo?user=postgres&password=root1234");)
		{
			String query="call insert_teacher_details(?,?,?,?,?,?)";
			CallableStatement callableStatement=connection.prepareCall(query);
			
			//Setting the values for each placeholders(?)
			callableStatement.setInt(1, 3);
			callableStatement.setString(2,"Salunke");
			callableStatement.setString(3, "female");
			callableStatement.setInt(4, 58);
			callableStatement.setString(5, "salunke@mail.com");
			callableStatement.setString(6, "AB+");
			
			callableStatement.execute();
			
			System.out.println("Procedure is executed Successfully!!!");
			
			
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}
}
