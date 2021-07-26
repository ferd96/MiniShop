package poly.store.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
