package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DTO.Teacher;

public class TestSecondLevelCache {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
		EntityManager em1 = emf.createEntityManager();
		EntityManager em2 = emf.createEntityManager();

		Teacher teacher1 = em1.find(Teacher.class, 1);
		Teacher teacher2 = em2.find(Teacher.class, 1);

		/*
		 * Error: Could not find or load main class DAO.TestSecondLevelCache Caused by:
		 * java.lang.ClassNotFoundException: DAO.TestSecondLevelCache
		 */
	}
}
