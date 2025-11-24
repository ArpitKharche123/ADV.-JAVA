package prod.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import prod.DTO.ApiResponseDTO;
import prod.DTO.ErrorResponseDTO;
import prod.DTO.ProductDTO;
import prod.model.Product;
import prod.service.IProductService;

@RestController
@RequestMapping("/products")
//@RequiredArgsConstructor

@Tag(name = "Product Management", description = "This List consists of some api endpoints which can be used to perform CRUD operations on Product Entity")
public class ProductController {
	// @Autowired
	// private IProductService productService;

	// or

	private final IProductService productService;

	// Constructor Injection
	public ProductController(IProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	@Operation(summary = "Add a new product", description = "Adds a new product to the database and returns the created product info.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Product Added successfully"),
			@ApiResponse(responseCode = "400", description = "Constraint Violation, null not allowed!", content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))) })
	public Product addProduct(@RequestBody ProductDTO productDto) {

		Product product = new Product();

		// Data mapping from DTO to Entity
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());

		return productService.saveProduct(product);
	}

	@GetMapping
	public List<Product> fetchAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product findProductById(@PathVariable int id) {
		Optional<Product> opt = productService.getProductById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody ProductDTO productDto) {

		Product product = new Product();

		// Data mapping from DTO to Entity
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setId(id);

		return productService.saveProduct(product);
	}

	@DeleteMapping("/{id}")
	public String deleteProductById(@PathVariable int id) {
		Optional<Product> product = productService.getProductById(id);
		if (product.isPresent()) {
			productService.deleteProductById(id);
			return "Product with id: " + id + " is deleted successfully!";
		} else {
			return "Product not found!";
		}
	}

	@DeleteMapping
	public String deleteAllProducts() {
		productService.deleteAll();
		return "All Products deleted successfully!";
	}

	// Media types
	@PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE // Accepts JSON
			, produces = MediaType.APPLICATION_XML_VALUE // return XML
	)
	public Product addProductXML(@RequestBody ProductDTO productDto) {

		Product product = new Product();

		// Data mapping from DTO to Entity
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());

		return productService.saveProduct(product);
	}

	// Response Structure
	@GetMapping("/getProduct/{id}")
	public ApiResponseDTO<Product> getProduct(@PathVariable int id) {
		Optional<Product> opt = productService.getProductById(id);

		ApiResponseDTO<Product> response = new ApiResponseDTO<Product>();

		if (opt.isPresent()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Product fetched successfully!");
			response.setData(opt.get());
		} else {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMessage("Product Not Found!");
		}
		return response;
	}

	// ResponseEntity
	@GetMapping("/getAll")
	public ResponseEntity<ApiResponseDTO<List<Product>>> getAllProducts() {
		List<Product> products = productService.getAllProducts();

		// to trigger 404
		products = new ArrayList<Product>();

		ApiResponseDTO<List<Product>> response = new ApiResponseDTO<List<Product>>();

		if (!products.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Products fetched successfully!");
			response.setData(products);

			return new ResponseEntity<ApiResponseDTO<List<Product>>>(response, HttpStatus.OK);

		} else {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMessage("Products Not Found!");

			return new ResponseEntity<ApiResponseDTO<List<Product>>>(response, HttpStatus.NOT_FOUND);
		}
	}
}
