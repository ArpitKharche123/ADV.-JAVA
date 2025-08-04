package connectionpoolexample;

import java.sql.Connection;
import java.sql.Statement;

public class ConnectionPoolDriver {

	public static void main(String[] args) {
		
		//Request/ Take connection object from Connection Pool 
		try(Connection connection= ConnectionPool.returnConnectionObject()){
			
			String query="INSERT INTO employees VALUES (6,'Alex','male')";
			
//			Statement statement=connection.createStatement();
//			statement.execute(query);
			
			//or
			
			//Execute query with that connection object
			connection.createStatement().execute(query);
			System.out.println("Employee is inserted successfully!");
			
			//Return that connection object back to the Connection Pool
			ConnectionPool.receiveConnectionObject(connection);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
