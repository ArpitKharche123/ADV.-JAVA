package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DTO.Teacher;

public class TestFirstLevelCache {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate");
		EntityManager em=emf.createEntityManager();
		
		Teacher teacher1=em.find(Teacher.class, 1);
		//executes select query
		System.out.println(teacher1);//prints teacher details
		
		System.out.println("-------------------");
		
		Teacher teacher2=em.find(Teacher.class, 1);
		//will not execute select query
		//instead, fetches teacher object from first level cache
		System.out.println(teacher1);//prints teacher details
	}

}
