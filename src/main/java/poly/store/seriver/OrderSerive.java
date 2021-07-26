package poly.store.seriver;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import poly.store.entity.Order;

public interface OrderSerive {

	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findByUsername(String username);

}
