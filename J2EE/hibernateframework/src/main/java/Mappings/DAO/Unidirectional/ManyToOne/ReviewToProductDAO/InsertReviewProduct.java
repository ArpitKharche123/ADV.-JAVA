package Mappings.DAO.Unidirectional.ManyToOne.ReviewToProductDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Mappings.DTO.Unidirectional.ManyToOne.ReviewsToProductDTO.Product;
import Mappings.DTO.Unidirectional.ManyToOne.ReviewsToProductDTO.Reviews;

public class InsertReviewProduct {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("many_to_one");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Product product = new Product();
		product.setId(1);
		product.setName("MacBook Pro");
		product.setCost(50000);

		Reviews review1 = new Reviews(1, "Fantastic", "Good Product", product);
		Reviews review2 = new Reviews(2, "Brilliant", "Nice Product", product);

		try {
			et.begin();
			em.persist(product);
			em.persist(review1);
			em.persist(review2);
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
		}
	}

}
