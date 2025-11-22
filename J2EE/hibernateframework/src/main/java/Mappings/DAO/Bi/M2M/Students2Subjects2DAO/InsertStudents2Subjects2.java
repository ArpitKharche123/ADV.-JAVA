package Mappings.DAO.Bi.M2M.Students2Subjects2DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Mappings.DTO.Bi.M2M.Students2Subjects2DTO.Students2;
import Mappings.DTO.Bi.M2M.Students2Subjects2DTO.Subjects2;

public class InsertStudents2Subjects2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("many_to_many_bi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Students2 student1 = new Students2();
		student1.setId(1);
		student1.setName("Akshay");
		student1.setEmail("ak@gmail.com");

		Students2 student2 = new Students2();
		student2.setId(2);
		student2.setName("Bikas");
		student2.setEmail("bik@gmail.com");

		Subjects2 subject1 = new Subjects2();
		subject1.setId(1);
		subject1.setName("Psycology");
		subject1.setDays(900);

		Subjects2 subject2 = new Subjects2();
		subject2.setId(2);
		subject2.setName("Dentistry");
		subject2.setDays(340);

		List<Subjects2> subjectList = new ArrayList();
		subjectList.add(subject1);
		subjectList.add(subject2);

		student1.setSubjects(subjectList);
		student2.setSubjects(subjectList);

		try {
			et.begin();
			for (Subjects2 subs : subjectList) {
				em.persist(subs);
			}
			em.persist(student1);
			em.persist(student2);

			System.out.println("Inserted Successfully!!");
			et.commit();

		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
		}
	}

}
