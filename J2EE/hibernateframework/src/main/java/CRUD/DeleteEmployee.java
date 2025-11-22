package CRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteEmployee {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Employee employee=em.find(Employee.class, 4);
		
		//Null Check
		if(employee!=null) {
			et.begin();
			em.remove(employee);
			et.commit();
			
			System.out.println("Employee is removed successfully!!");
		}else {
			System.err.println("Employee does not exists!");
		}
	}

}
