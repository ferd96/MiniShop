package poly.store.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.store.entity.Product;
import poly.store.seriver.ProductSerive;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	ProductSerive productSerive;
	
	@GetMapping("{id}")
	public Product getOne( @PathVariable("id") Integer id) {
		return productSerive.findById(id);
	}

	@GetMapping()
	public List<Product> getAll() {
		return productSerive.findAll();
	}
	
	@PostMapping
	public Product create(@RequestBody Product product) {
		return productSerive.create(product);
	}
	
	@PutMapping("{id}")
	public Product update(@PathVariable("id")Integer id,@RequestBody Product product) {
		return productSerive.update(product);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		productSerive.delete(id);
	}
}
