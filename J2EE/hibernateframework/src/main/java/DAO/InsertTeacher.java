package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.Teacher;

public class InsertTeacher {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Teacher teacher=new Teacher();
		
		//Teacher teacher=em.find(Teacher.class, 2);
		teacher.setName("harry");
		teacher.setEmail("harry@gmail.com");
		teacher.setPhone(9800092804l);
	
		try {
			et.begin();
			em.persist(teacher);
			//em.merge(teacher);
			et.commit();
		} catch (Exception e) {
			if(et.isActive())
				et.rollback();
		}

	}

}
