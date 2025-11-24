package prod.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prod.model.Product;
import prod.repository.ProductRepository;

@Service
//@RequiredArgsConstructor
public class ProductService implements IProductService{
	//final ProductRepository productRepository;
	
	//or
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}	
	
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	
	public Optional<Product> getProductById(int id) {
		return productRepository.findById(id);
	}
	
	
	public void deleteProductById(int id) {
		productRepository.deleteById(id);
	}
	
	public void deleteAll() {
		productRepository.deleteAll();
	}
	
	
	
}
