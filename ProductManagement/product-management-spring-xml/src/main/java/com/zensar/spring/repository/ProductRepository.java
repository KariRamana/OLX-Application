package com.zensar.spring.repository;

import com.zensar.spring.beans.Product;

public interface ProductRepository {

	public int insertProduct(Product product);

	public int UpdateProduct(Product product);

	public boolean deleteProduct(int productId);

	//public List<Product> findAll();

}
