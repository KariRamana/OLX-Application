package com.zensar.spring.service;

import java.util.List;

import com.zensar.spring.beans.Product;

public interface ProductService {

	public int insertProduct(Product product);
	 public int UpdateProduct(Product product);
	 public boolean deleteProduct(int productId);
	// public List<Product> findAll();
}
