package poly.store.seriver;

import java.util.List;
import java.util.Optional;

import poly.store.entity.Product;

public interface ProductSerive {

	

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);



	

}
