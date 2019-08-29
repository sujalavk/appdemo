package com.niit.TestCase;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.CartDao;
import com.niit.Model.Cart;

public class CartTestCase {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Cart cart;

	@Autowired
	private static CartDao cartDao;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cart = (Cart) context.getBean("cart");
		cartDao = (CartDao) context.getBean("cartDao");

	}

	@Test
	public void insertCartTestCase() {
		cart.setP_id(1);
		cart.setP_name("kurtha");
		cart.setPrice(2000.0f);
		cart.setQuantity(2);
cart.setStatus("order");
cart.setU_id("aaa");
		boolean flag = cartDao.insertCart(cart);

		Assert.assertEquals("insertCartTestCase", true, flag);

	}


}
