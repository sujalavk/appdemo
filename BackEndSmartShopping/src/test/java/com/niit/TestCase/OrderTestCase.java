package com.niit.TestCase;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.CartDao;
import com.niit.Dao.OrderDao;
import com.niit.Model.OrderDetail;

public class OrderTestCase {

	@Autowired
		private static OrderDao orderDao;
	@Autowired
		CartDao cartItemDao;
		
		@BeforeClass
		public static void executeFirst()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.niit");
			context.refresh();
			orderDao=(OrderDao)context.getBean("orderDao");
			
		}
		//@Ignore
		@Test
		public void createOrderTest()
		{
			OrderDetail order=new OrderDetail();
			order.setOrderDate(new Date());
			order.setPaymentMode("CC");
			order.setUsername("Rohan");
			order.setTotalAmount(5000);
			assertTrue("Problem creating order",orderDao.createOrder(order));
		}
		
		@Ignore
		@Test
		public void updateCartItemStatusTest()
		{
			assertTrue("Problem in updating Cart item status",orderDao.updateCartItemStatus("Rohan"));
			
		}
		
		@Ignore
		@Test
		public void listOrdersTest()
		{
			List<OrderDetail> ordersList=orderDao.listOrders("abc");
			assertTrue("Problem in listing orders",orderDao.listOrders("abc").size()>0);
			for(OrderDetail order : ordersList)
			{
				System.out.println(order.getOrderId());
			}
		}
	}



