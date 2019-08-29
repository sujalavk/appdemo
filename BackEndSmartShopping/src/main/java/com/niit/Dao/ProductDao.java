package com.niit.Dao;


import java.util.List;

import com.niit.Model.Product;

public interface ProductDao {
	// get all categories

		public List<Product>listProducts();

		// create product

		public boolean insertProduct(Product product);

		// update product

		public boolean updateProduct(Product product);

		// delete product by id

		public boolean deleteProduct(int id);

		// delete product by product

		public boolean deleteProduct(Product product);

		// get product by id

		public Product getProductByID(int id);

		// get product by name
		public Product getProductByName(String name);

	}


