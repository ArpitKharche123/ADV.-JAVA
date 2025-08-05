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
	
	Statement statement = connection.createStatement();
	
	String query="SELECT * FROM employees ORDER BY id ASC";
	
	//Way 1
//	statement.execute(query);
//	ResultSet resultSet = statement.getResultSet();
	
	//or
	
	//Way 2(More readable)
	ResultSet resultSet=statement.executeQuery(query);

	//Moving the cursor from 1st row till last row
	while(resultSet.next()) {
		
	//Fetching and Printing the values of each row	
	int id=resultSet.getInt("id");
	String name=resultSet.getString(2);
	String gender=resultSet.getString(3);
	
	System.out.println(id+" "+name+" "+gender);
	
	}

	connection.close();
	statement.close();

	
}  catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
}
