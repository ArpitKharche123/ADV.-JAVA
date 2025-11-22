package Mappings.DAO.Bi.M2M.Students2Subjects2DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Mappings.DTO.Bi.M2M.Students2Subjects2DTO.Students2;
import Mappings.DTO.Bi.M2M.Students2Subjects2DTO.Subjects2;

public class FindStudents2Subjects2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("many_to_many_bi");
		EntityManager em = emf.createEntityManager();

		Query fetchStudents = em.createQuery("Select s from Students2 s");

		List<Students2> studentList = fetchStudents.getResultList();

		System.out.println("Student Details: ");
		for (Students2 student : studentList) {
			System.out.println(student.getId() + " " + student.getName() + " " + student.getEmail());
			System.out.println("Subjects Enrolled:  ");
			List<Subjects2> subjectList = student.getSubjects();
			for (Subjects2 subject : subjectList) {
				System.out.println(subject.getId() + " " + subject.getName() + " " + subject.getDays() + " ");
			}
			System.out.println("------------------------");
		}

	}

}
