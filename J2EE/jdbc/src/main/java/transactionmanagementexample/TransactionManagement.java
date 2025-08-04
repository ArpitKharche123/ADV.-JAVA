package transactionmanagementexample;

import java.sql.Connection;
import java.sql.Savepoint;

import connectionpoolexample.ConnectionPool;

public class TransactionManagement {

	public static boolean isPaymentSuccess() {
		return true;
	}
	
	public static void main(String[] args) {
		
		try(Connection connection=ConnectionPool.returnConnectionObject()){
			
			//booking_info table
			String booking_info="INSERT INTO booking_info "
					          + "VALUES(1,'10 august','Namakkal','Banglore')";
			
			//passenger_info table
			String passenger_info1="INSERT INTO passenger_info "
					          + "VALUES (1,'Shyam','male')";
			String passenger_info2="INSERT INTO passenger_info "
			          + "VALUES (2,'Gita','female')";
			String passenger_info3="INSERT INTO passenger_info "
			          + "VALUES (3,'Harshit','male')";
			
			//payment_info table
			String payment_info="INSERT INTO payment_info "
							+ "VALUES (1,'6000',10,'requested')";
			
			//Transaction Start
			
			connection.setAutoCommit(false);
			
			//Step 1: Executing booking_info
			connection.createStatement().execute(booking_info);
			
			//It will act as a mark/flag
			Savepoint savepoint=connection.setSavepoint();
			//Only persists booking_info table data
			
			//Step 2: Executing passenger_info
			connection.createStatement().execute(passenger_info1);
			connection.createStatement().execute(passenger_info2);
			connection.createStatement().execute(passenger_info3);
			

			//Step 3: Executing payment_info
			
			if(!isPaymentSuccess()) {
			
			//if payment is successful, 
			//then inserting the data in payment_info table 	
			connection.createStatement().execute(payment_info);
			
			//Saving all the changes
			connection.commit();
			System.out.println("Transaction is completed successfully!!");
			}
			else {
				
				//Undoes all temporary changes(execute() methods)
//				connection.rollback();
//				System.err.println("Transaction failed!! Data reverted!");
				
				//or
				
				//Using SavePoint
				connection.rollback(savepoint);//Only persists booking_info table data
				connection.commit();
				
				System.out.println("Rolled back till savepoint 1");
			}
			
			//Transaction End
			
			ConnectionPool.receiveConnectionObject(connection);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
