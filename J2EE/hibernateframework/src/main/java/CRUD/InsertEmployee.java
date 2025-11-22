package CRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Utils.PersistenceUnitReader;

public class InsertEmployee {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory(PersistenceUnitReader.getPersistenceUnitName());
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//Creating instance of Entity Class Employee
//		Employee e=new Employee();
//		e.setEname("Tokita");
//		e.setEmail("tkt@email.com");
//		e.setBloodGroup("A+");
//or
		
		Employee e2=new Employee(1,"Glen","glen@gmail.com","B+");
		et.begin();
		em.persist(e2);
		et.commit();
		
		System.out.println("Employee is added successfully!\n"+e2);
	}

}
