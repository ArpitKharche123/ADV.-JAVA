package MetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSet_Metadata {

	public static void main(String[] args) {
		try(Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost/demo?user=postgres&password=root1234")){
			
			String query="SELECT * FROM teacher_info";
			
			//connection.createStatement().executeQuery(query);
			
			Statement statement=connection.createStatement();
			
			ResultSet set = statement.executeQuery(query);
			
			ResultSetMetaData metaData = set.getMetaData();
			
			System.out.println("Column Count: "+metaData.getColumnCount());
			
			System.out.println("Column Name: "+metaData.getColumnLabel(4));
			System.out.println("Column Name: "+metaData.getColumnName(1));
			
			System.out.println("Column Type: "+metaData.getColumnTypeName(1));
			
		}catch (Exception e) {
		e.printStackTrace();
		}

	}

}
