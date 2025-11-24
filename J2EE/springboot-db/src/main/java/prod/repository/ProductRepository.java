package prod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import prod.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	// JpaRepository automatically provides CRUD methods like
	// save(), findAll(), findById(), deleteById(), etc
	
	
	//Custom Methods:
	//will be internally translated to SQL queries!
	
	
	//By fields
	List<Product> findByName(String name);
	List<Product> findByNameAndPrice(String name, double price);
	List<Product> findByNameOrPrice(String name, double price);
	boolean existsByName(String name);
	boolean existsById(int id);
	
	//Range or pattern
	List<Product> findByPriceGreaterThan(double price);
	List<Product> findByPriceBetween(double min, double max);
	List<Product> findByNameContaining(String keyword);
	List<Product> findByNameStartingWith(String prefix);

	
	Product findFirstByName(String name);
	List<Product> findTop3ByOrderByPriceDesc();
	
	long countByName(String name);
	
	//Custom JPQL Query
	
	//if method param and query param are same, then there is not need to use @Param
	//but it may not work some times(due to IDE configurations)
	//so the safer practice is always use @Param
	@Query("SELECT p FROM Product p WHERE p.name = :name AND p.price < :price")
	List<Product> findProductsUnderPrice(@Param("name") String prod_name,@Param("price") double price);

//or match all the method param with  query param(here no need of @Param)
	@Query("SELECT p FROM Product p WHERE p.name = :name AND p.price < :price")
	List<Product> findProductsUnderPrice2(String name, double price);

	





	
	

}
