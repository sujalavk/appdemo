package com.niit.TestCase;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.ProductDao;
import com.niit.Model.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Product product;
	
	@Autowired
	private static ProductDao productDao;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		product = (Product) context.getBean("product");
		productDao = (ProductDao) context.getBean("productDao");

	}
	@Ignore
	@Test
	public void insertProductTestCase() {
		product.setPid(1);
		product.setPname("tomato");
		product.setDescription("hybrid");
		product.setCategory_id("1");
		product.setPrice(20.0f);
		product.setStock(55);
     product.setSupplier_id("1");
		boolean flag = productDao.insertProduct(product);

		Assert.assertEquals("insertProductTestCase", true, flag);

	}

	
	//@Ignore
	@Test
	public void updateProductTestCase() {
		product.setPid(168);
		product.setPname("tomato");
		product.setDescription("local");
		product.setCategory_id("1");
		product.setPrice(20.0f);
		product.setStock(55);
     product.setSupplier_id("1");
		boolean flag = productDao.updateProduct(product);

		Assert.assertEquals("insertProductTestCase", true, flag);

	}

}
