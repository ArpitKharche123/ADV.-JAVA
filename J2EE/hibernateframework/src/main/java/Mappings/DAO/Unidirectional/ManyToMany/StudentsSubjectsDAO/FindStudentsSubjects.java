package Mappings.DAO.Unidirectional.ManyToMany.StudentsSubjectsDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Mappings.DTO.Unidirectional.ManyToMany.StudentsSubjectsDTO.Students;
import Mappings.DTO.Unidirectional.ManyToMany.StudentsSubjectsDTO.Subjects;

public class FindStudentsSubjects {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("many_to_many");
		EntityManager em = emf.createEntityManager();

		Query fetchStudents = em.createQuery("select s from Students s");
		List<Students> studentList = fetchStudents.getResultList();

		System.out.println("Student Details");
		for (Students students : studentList) {
			System.out.println("Id: " + students.getId());
			System.out.println("Name: " + students.getName());
			System.out.println("Email: " + students.getEmail());
			List<Subjects> subjectList = students.getSubjects();
			System.out.println("Subjects taken by " + students.getName());
			for (Subjects subjects : subjectList) {
				System.out.println("Subject Id: " + subjects.getId());
				System.out.println("Subject Name: " + subjects.getName());
				System.out.println("Duration: " + subjects.getDays() + " days");
			}
		}

	}

}
