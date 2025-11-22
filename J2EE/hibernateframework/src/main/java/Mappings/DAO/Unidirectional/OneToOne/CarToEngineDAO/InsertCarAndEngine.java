package Mappings.DAO.Unidirectional.OneToOne.CarToEngineDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Mappings.DTO.Unidirectional.OneToOne.CarToEngineDTO.Car;
import Mappings.DTO.Unidirectional.OneToOne.CarToEngineDTO.Engine;

public class InsertCarAndEngine {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		Engine engine = new Engine(1, "Petrol", 1000);
		Car car = new Car(101, "BMW", 2300000, engine);

		try {
			et.begin();
			em.persist(car);
			em.persist(engine);
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) { // to prevent IllegalStateException!
									// Transaction was already committed, can't rollback!
				et.rollback();// to prevent partial updation when performing multiple operations
				// and ensure all or nothing
			}
			e.printStackTrace();
		}

	}

}
