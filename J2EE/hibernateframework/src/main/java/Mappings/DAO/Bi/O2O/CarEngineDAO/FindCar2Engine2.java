package Mappings.DAO.Bi.O2O.CarEngineDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Mappings.DTO.Bi.O2O.CarEngineDTO.Car2;
import Mappings.DTO.Bi.O2O.CarEngineDTO.Engine2;

public class FindCar2Engine2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_one_bi");
		EntityManager em = emf.createEntityManager();

		Query fetchCars = em.createQuery("Select c from Car2 c");
		Query fetchEngines = em.createQuery("Select e from Engine2 e");

		List<Car2> cars = fetchCars.getResultList();
		List<Engine2> engines = fetchEngines.getResultList();

		System.out.println("Car details: ");
		for (Car2 car2 : cars) {
			System.out.println(car2.getId() + " " + car2.getName() + " " + car2.getCost() + " ");
			System.out.println("Engine: ");
			Engine2 engine2 = car2.getEngine();
			System.out.println(engine2.getId() + " " + engine2.getType() + " " + engine2.getCc() + " ");
			System.out.println("-------------");
		}
	}

}
