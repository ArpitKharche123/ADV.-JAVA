package CRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchEmployee {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
		EntityManager em = emf.createEntityManager();

		Employee emp = em.find(Employee.class, 1);
		// If non-existent primary key is given, we will get NullPointerException

		// Null Check
		if (emp != null) {
			System.out.println("eid: " + emp.getEid() + "\nName: " + emp.getEname() + "\nEmail: " + emp.getEmail()
					+ "\nBlood Group: " + emp.getBloodGroup());
		} else {
			System.err.println("Employee with provided pk does'nt exsists");
			System.out.println();
		}
	}

}
