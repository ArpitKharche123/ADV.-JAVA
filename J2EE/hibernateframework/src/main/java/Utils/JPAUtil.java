package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static EntityManagerFactory getEntityManagerFactory(String persistenceUnit) {
		entityManagerFactory=Persistence.createEntityManagerFactory(persistenceUnit);
		return entityManagerFactory;
	}
	public static EntityManager getEntityManager(EntityManagerFactory entityManagerFactory) {
		entityManager= entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
}
