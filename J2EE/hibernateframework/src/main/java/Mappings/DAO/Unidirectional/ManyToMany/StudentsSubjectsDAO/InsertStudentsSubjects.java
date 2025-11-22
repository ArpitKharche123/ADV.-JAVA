package Mappings.DAO.Unidirectional.ManyToMany.StudentsSubjectsDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Mappings.DTO.Unidirectional.ManyToMany.StudentsSubjectsDTO.Students;
import Mappings.DTO.Unidirectional.ManyToMany.StudentsSubjectsDTO.Subjects;

public class InsertStudentsSubjects {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("many_to_many");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Subjects subject1 = new Subjects(1, "Maths", 90);
		Subjects subject2 = new Subjects();
		subject2.setId(2);
		subject2.setName("Physics");
		subject2.setDays(90);
		Subjects subject3 = new Subjects(3, "Chemistry", 90);

		// List<Subjects> subjects=Arrays.asList(subject1,subject2,subject3);//not
		// resizable!!!
		List<Subjects> subjects = new ArrayList<Subjects>();
		subjects.add(subject1);
		subjects.add(subject2);
		subjects.add(subject3);

		Students student1 = new Students();
		student1.setId(1);
		student1.setName("Rahul");
		student1.setEmail("r@gmail.com");
		student1.setSubjects(subjects);

		// Adding only 2 subject for student 2
		List<Subjects> subjects2 = Arrays.asList(subject1, subject2);
		Students student2 = new Students(2, "Akash", "a@gmail.com", subjects2);

		try {
			et.begin();
			// Saving all subjects
			for (Subjects subs : subjects) {
				em.persist(subs);
			}
			// Saving students
			em.persist(student1);
			em.persist(student2);

			et.commit();
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
		}

	}

}
