package CRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateEmployee {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Employee employee = em.find(Employee.class, 10);

		// Null Check
		if (employee != null) {
			employee.setEmail("tokita@gmail.com");

			et.begin();
			em.merge(employee);
			et.commit();

			System.out.println("Employee is updated successfully!!");
		} else {
			System.err.println("Employee does not exists!");
		}
	}

}
