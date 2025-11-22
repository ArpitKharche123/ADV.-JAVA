package CRUD;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SelectAllEmployees {

	@SuppressWarnings({ "unchecked", "unused" })
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate");
		EntityManager em=emf.createEntityManager();
		
		//Query is an interface used to control query execution.
		
		//creayeQuery Create an instance of Query 
		//for executing aJava Persistence query language statement.
	   Query query=em.createQuery("select e from Employee e");
	   
	   //getResultList() executes a SELECT query

	   List<Employee> employees=query.getResultList();
	   
	   for(Employee e:employees) {
		   System.out.println(e);
	   }
	}

}
