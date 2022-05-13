/*package com.zensar.spring.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.zensar.spring.beans.Product;

public class ProductRepositoryImpl2 implements ProductRepository {

	private NamedParameterJdbcTemplate template;

	// insert

	public int insertProduct(Product product) {
		String sql = "INSERT INTO product (productId, productName, productCost) VALUES (:productId, :productName, :productCost)";

		Map<String, String> products = new HashMap<String, String>();

		products.put("productId", "1");
		products.put("productName", "Laptop");
		products.put("productCost", "55483");
		return template.update(sql, products);
	}

	// delete

	public boolean deleteProduct(int productId) {
		SqlParameterSource namedParameter = new MapSqlParameterSource("productId", productId);
		String sql = "delete from product where productId=:productId";

		return template.update(sql, namedParameter) > 0;
	}

//	// update

	public int UpdateProduct(Product product) {
		String sql = "update product set productName = :productName, productCost = :productCost where productId=:productId";

		Map<String, String> products = new HashMap<String, String>();

		products.put("productId", "2");
		products.put("productName", "Laptop");
		products.put("productCost", "51283");
		return template.update(sql, products);
	}

	public NamedParameterJdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

}
*/