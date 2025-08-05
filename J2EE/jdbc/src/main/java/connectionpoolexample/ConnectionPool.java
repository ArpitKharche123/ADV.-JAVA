package connectionpoolexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {
	
	//Connection Pool
	static ArrayList<Connection> pool=new ArrayList<Connection>();
	
	//Max Pool Size
	static final int POOL_SIZE=10;
	
	static Connection connection=null;
	
	//Method which creates and returns connection object
	
	static Connection createConnection() {
		try {
			 connection=DriverManager.getConnection("jdbc:postgresql://localhost/demo?user=postgres&password=root1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
	//Adding connection objects inside connection pool
	
	//Whenever the class is loaded, connection objects will be added
	// inside the connection pool
	static {
		for(int i=0;i<POOL_SIZE;i++) {
			
			//Getting connection objects
			Connection connection=createConnection();
			
			//Adding them into connection pool
			pool.add(connection);
		}
	}
	
	//Method to return the connection Object to the caller
	//Caller is the one who requests the connection object
	public static Connection returnConnectionObject() {
		//if pool is not empty
		if(!pool.isEmpty()) {
			
			//then it will remove one connection object 
			//from the pool and return it
			return pool.remove(0);
		}
		else {
			//if connection pool is empty,
			//new connection object is created and returned
			return createConnection();
		}
	} 
	
	//Method to receive connection object back from the caller
	public static void receiveConnectionObject(Connection connection) {
		
		//if pool size is lesser than max pool size
		if(pool.size()<POOL_SIZE) {
			
			//add the connection object back to the pool
			pool.add(connection);
		}
		else {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
