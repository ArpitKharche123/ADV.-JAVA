package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class select {
public static void main(String[] args) {
	
	String fullUrl=
	"jdbc:postgresql://localhost:5432/demo?user=postgres&password=root1234";
	
	String url="jdbc:postgresql://localhost:5432/demo";
	String user="postgres";
	String	password="root1234";
	
	try {
		
	Connection connection = DriverManager.getConnection(fullUrl);
	
	System.out.println("Connnection is established");
	
	//Step 3:Create or Prepare the Statement
	
	Statement statement = connection.createStatement();
	
	//Step 4:Execute the query
	String query="SELECT * FROM employees ORDER BY id ASC";
	
	//Way 1
//	statement.execute(query);
//	ResultSet resultSet = statement.getResultSet();
	
	//or
	
	//Way 2
	ResultSet resultSet=statement.executeQuery(query);

	while(resultSet.next()) {
		
	int id=resultSet.getInt("id");
	String name=resultSet.getString(2);
	String gender=resultSet.getString(3);
	
	System.err.println(id+" "+name+" "+gender);
	
	}
	

	
	
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
