package MetaData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMetadata {
	public static void main(String[] args) {
		
		try(Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost/demo?user=postgres&password=root1234");){
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("Username: "+metaData.getUserName());
			System.out.println("Driver Version: "+metaData.getDriverVersion());
			System.out.println("Driver Name: "+metaData.getDriverName());
			System.out.println("Url: "+metaData.getURL());
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
