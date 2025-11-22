package DynamicCRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import CRUD.Employee;

public class FetchEmployeeByBloodGroup {

	public static void main(String[] args) {

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate");
		EntityManager em=emf.createEntityManager();

		String query="Select e from Employee e "+
					 "where e.bloodGroup=?1";
		
		Query fetchEmpByBGQuery=em.createQuery(query);
		
		fetchEmpByBGQuery.setParameter(1, "B+");
		
		Employee emp =(Employee) fetchEmpByBGQuery.getSingleResult();
		
		System.out.println(emp.getEname());

	}

}
