package prod.service;

import java.util.List;
import java.util.Optional;

import prod.model.Product;

public interface IProductService {
	/**
	 * Saves new product or updates existing products. Works similar to persist()
	 * and merge()
	 * 
	 * @param product {@link Product} type reference variable
	 * @return object of type {@link Product}
	 */
	public Product saveProduct(Product product);

	/**
	 * fetches all the products.
	 * 
	 * @return List of type {@link Product}
	 * 
	 */
	public List<Product> getAllProducts();

	/**
	 * Fetches the product based on the given ID.
	 *
	 * @param id the ID of the product to fetch
	 * @return an {@link Optional} containing the {@link Product} if found,
	 *         otherwise empty
	 */
	public Optional<Product> getProductById(int id);

	/**
	 * Deletes the product based on the given ID.
	 *
	 * @param id the ID of the product to delete
	 */
	public void deleteProductById(int id);

	/**
	 * Deletes all the products.
	 *
	 */
	public void deleteAll();
}
