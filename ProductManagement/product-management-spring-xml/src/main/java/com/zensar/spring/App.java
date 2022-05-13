package com.zensar.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.spring.beans.Product;
import com.zensar.spring.service.ProductService;

public class App  {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

		ProductService service = context.getBean("service", ProductService.class);
		// insert
		Product product = new Product(2, "AC", 10000);
		service.insertProduct(product);

		System.out.println("Product inserted successfullyyyyy !!!");
		// delete
		//service.deleteProduct(1);

		System.out.println("Product deleted successfullyyyyy !!!");
		// update
		service.UpdateProduct(new Product(1, "Laptop", 20000));

		System.out.println("Product updated successfullyyyyy !!!");
		//read
		//service.findAll();

		System.out.println("Product read successfullyyyyy !!!");
	}
	
}
