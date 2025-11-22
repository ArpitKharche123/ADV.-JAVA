package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.Bike;

public class InsertBike {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Bike bike=new Bike();
		bike.setName("BMW1250GSA");
		bike.setType("ADV");
		
		try {
			et.begin();
			em.persist(bike);
			et.commit();
		} catch (Exception e) {
			if(et.isActive())
				et.rollback();
		}

	}

}
