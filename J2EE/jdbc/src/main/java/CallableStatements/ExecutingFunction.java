package CallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecutingFunction {

	public static void main(String[] args) {
		try(Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost/demo?user=postgres&password=root1234");){
			
			CallableStatement callableStatement=connection.prepareCall("SELECT count_by_gender(?)");
			
			callableStatement.setString(1, "female");
			
			ResultSet set = callableStatement.executeQuery();
			
			System.out.println("Function is executed successfully!!!");
			
			set.next();
			
			int count = set.getInt(1);
			System.out.println("Count :"+count);
			
				
			}catch(SQLException e) {
				e.printStackTrace();
			}

	}

}
