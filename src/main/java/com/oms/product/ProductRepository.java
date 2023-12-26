package com.oms.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.orders.Order;

public interface ProductRepository extends JpaRepository <Product, Integer> {

	List<Product> findAll();

	 Optional<Product> findById(int productId);

	Product save(Product product);

	void delete(Product existingProduct);

	

}
