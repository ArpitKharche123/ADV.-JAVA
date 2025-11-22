package Mappings.DAO.Unidirectional.OneToOne.CarToEngineDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Mappings.DTO.Unidirectional.OneToOne.CarToEngineDTO.Car;

public class FindCarEngine {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Car car = em.find(Car.class, 101);

		et.begin();
		// em.remove(car);
		et.commit();

	}
}
