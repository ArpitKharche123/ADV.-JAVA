package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.CompositeKeysOfProfile;
import DTO.Profile;

public class UserProfileInsert {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Profile profile=new Profile();
		profile.setCk(new CompositeKeysOfProfile(1,"abc@gmail.com",9878909872l));
		profile.setName("abc");
		profile.setAge(15);
		profile.setGender("female");
		
		if(profile!=null) {
			et.begin();
			em.persist(profile);
			et.commit();
			System.out.println("UserProfile added successfully");
		}
		else {
			System.err.println("Something went wrong");
		}
	}
}
