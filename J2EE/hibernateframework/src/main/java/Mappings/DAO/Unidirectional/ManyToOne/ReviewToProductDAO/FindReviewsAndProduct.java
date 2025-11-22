package Mappings.DAO.Unidirectional.ManyToOne.ReviewToProductDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Mappings.DTO.Unidirectional.ManyToOne.ReviewsToProductDTO.Product;
import Mappings.DTO.Unidirectional.ManyToOne.ReviewsToProductDTO.Reviews;

public class FindReviewsAndProduct {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("many_to_one");
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("Select r from Reviews r");

		List<Reviews> reviews = query.getResultList();
		for (Reviews reviews2 : reviews) {
			System.out.println(reviews2.getId() + " " + reviews2.getHeading() + " " + reviews2.getMessage() + " ");
			System.out.println("Product details: ");
			Product product = reviews2.getProduct();
			System.out.println(product.getId() + " " + product.getName() + " " + +product.getCost() + " ");
		}

	}

}
