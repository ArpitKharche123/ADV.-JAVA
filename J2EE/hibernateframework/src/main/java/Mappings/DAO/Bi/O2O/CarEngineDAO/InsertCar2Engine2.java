package Mappings.DAO.Bi.O2O.CarEngineDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Mappings.DTO.Bi.O2O.CarEngineDTO.Car2;
import Mappings.DTO.Bi.O2O.CarEngineDTO.Engine2;

public class InsertCar2Engine2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_one_bi");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		Engine2 engine = new Engine2();
		engine.setId(1);
		engine.setType("Petrol");
		engine.setCc(800);

		Car2 car = new Car2();
		car.setId(1);
		car.setName("Audi");
		car.setCost(1000000);

		// Bi-directional association
		engine.setCar(car);
		car.setEngine(engine);

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
