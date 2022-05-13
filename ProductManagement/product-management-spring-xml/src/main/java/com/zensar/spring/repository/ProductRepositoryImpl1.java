package com.zensar.spring.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zensar.spring.beans.Product;

public class ProductRepositoryImpl1 implements ProductRepository {

	private JdbcTemplate template;
	// private NamedParameterJdbcTemplate template;

	/*
	 * class ProductRowMapper implements RowMapper<Product> {
	 * 
	 * public Product mapRow(ResultSet rs, int rowNum) throws SQLException { Product
	 * product = new Product(); product.setProductId(rs.getInt("productId"));
	 * product.setProductName(rs.getString("productName"));
	 * product.setProductCost(rs.getInt("productCost")); return product;
	 * 
	 * } }
	 * 
	 * public List<Product> findAll() { // TODO Auto-generated method stub return
	 * template.query("select * from employees", new ProductRowMapper()); }
	 * 
	 * public Optional<Product> findById(long id) { return
	 * Optional.of(template.queryForObject("select * from employees where id=?", new
	 * Object[] { id }, new BeanPropertyRowMapper<Product>(Product.class))); }
	 */

//insert
	public int insertProduct(Product product) {
		// createTable();
		String sql = "insert into product values(" + product.getProductId() + ",'" + product.getProductName() + "',"
				+ product.getProductCost() + ");";
		template.execute(sql);
		return 1;
	}

	public void createTable() {
		template.execute("create table product(productId int ,productName varchar(50),productCost int)");
	}

//update
	public int UpdateProduct(Product product) {
		String sql = "update product set productName= ? , productCost= ?  where ProductId =?";
		return template.update(sql, product.getProductName(), product.getProductCost(), product.getProductId());

	}

//delete
	public boolean deleteProduct(int productId) {
		String sql = "delete from product where ProductId=?";
		return template.update(sql, productId) > 0;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	/*
	 * class ProductRowMapper implements RowMapper<Product> {
	 * 
	 * public Product mapRow(ResultSet rs, int rowNum) throws SQLException { Product
	 * product = new Product(); product.setProductId(rs.getInt("productId"));
	 * product.setProductName(rs.getString("productName"));
	 * product.setProductCost(rs.getInt("productCost")); return product;
	 * 
	 * } }
	 * 
	 * public List<Product> findAll() { return
	 * template.query("select * from productId", new ProductRowMapper()); } public
	 * Optional < Product > findById(long id) { return
	 * Optional.of(template.queryForObject("select * from employees where id=?", new
	 * Object[] { id }, new BeanPropertyRowMapper < Product> (Product.class))); }
	 */
}