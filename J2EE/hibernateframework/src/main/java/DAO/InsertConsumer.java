package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
public class InsertConsumer {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		DTO.Consumer consumer=new DTO.Consumer();
		consumer.setName("Denver");	
			
		try {
			et.begin();
			em.persist(consumer);
			et.commit();
		} catch (Exception e) {
			if(et.isActive())
				et.rollback();
		}

	}

}
