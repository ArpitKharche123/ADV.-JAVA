package DynamicCRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateEmployee {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		try {
			et.begin();
			
			String email="glenMax@gmail.com",
					bloodgrp="A+";
			
			String query="Update Employee e "
						+" set  e.email=?1 , e.bloodGroup=?2 "
						+ "where e.eid=:empId";
			
			Query updateEmp=em.createQuery(query);
			
				updateEmp.setParameter(1,email);
				updateEmp.setParameter(2, bloodgrp);
			   updateEmp.setParameter("empId", 1);

			int rowsAffected = updateEmp.executeUpdate();
			System.out.println(rowsAffected+" no. of rows affected");
			
			et.commit();
		} catch (Exception e) {
			if(et.isActive())
				et.rollback();
			e.printStackTrace();
		}
	}

}
