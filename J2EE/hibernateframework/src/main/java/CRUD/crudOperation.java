package CRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class crudOperation {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
		EntityManager em = emf.createEntityManager();

		// Required only for DML operations
		EntityTransaction et = em.getTransaction();

		// Creating Entity Class Object
		Employee employee = new Employee(1, "Alex", "a@gmail.com", "A+");

		// Fetching object details(DQL)
		Employee e = em.find(Employee.class, 1);
		System.out.println("Id: " + e.getEid());

		// Begin Transation
		et.begin();

		// Saving Object
		em.persist(employee);

		// Update record
		em.merge(employee);

		// Delete record
		em.remove(employee);

		et.commit();

	}

}
