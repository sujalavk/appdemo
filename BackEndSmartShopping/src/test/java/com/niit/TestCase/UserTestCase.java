package com.niit.TestCase;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.UserDao;
import com.niit.DaoImpl.UserDaoImpl;
import com.niit.Model.Address;
import com.niit.Model.User;
import com.niit.config.HibernateConfig;

import junit.framework.TestCase;

public class UserTestCase {
	@Autowired
	private static User user;
	
	@Autowired
	private static UserDao userDao;

	private Address address = null;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
		context.scan("com.niit"); 
		context.refresh();
		
       user=(User)context.getBean("user");
		
		
		userDao = (UserDao)context.getBean("userDao");
		System.out.println("init");
	}
	
	@Test
	public void insertUserTestCase()
	{
	   
		 user.setEmail("admin@gmail.com");
		 user.setName("xyz");
		 user.setAddress("hubli");
		 user.setPassword("1234");
		 user.setPhone("69865422");
		 user.setRole("ROLE_ADMIN");
		 user.setEnabled(true);;
		 boolean flag=userDao.save(user);
		
		 System.out.println("db connected");
		 Assert.assertEquals( "insertUserTestCase" ,true, flag);
		
		
	}
	
	/*@Test
	public void testAddUser() {
		 user.setEmail("xyz@gmail.com");
		 user.setName("xyz");
		 user.setAddress("mumbai");
		 user.setPassword("niit@123");
		 user.setPhone("69865422");
		 user.setRole("ROLE_USER");
		 user.setEnabled(true);
		 boolean flag=userDao.save(user);
		
		 System.out.println("db connected");
		 Assert.assertEquals( "insertUserTestCase" ,true, flag);
		user = userDao.getUser("xyz@gmail.com");
		// add the address
		address = new Address();
		address.setAddressLineOne("301/B Jadoo Society, King Uncle Nagar");
		address.setAddressLineTwo("Near Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);	
		
		
		address.setUser(user);
		
		Assert.assertEquals("Failed to add the address!", true, userDao.addAddress(address));	
		// add the shipping address
				address = new Address();
				address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
				address.setAddressLineTwo("Near Kudrat Store");
				address.setCity("Mumbai");
				address.setState("Maharashtra");
				address.setCountry("India");
				address.setPostalCode("400001");
				address.setShipping(true);
				address.setUser(user);
				Assert.assertEquals("Failed to add the shipping address!", true, userDao.addAddress(address));
		
		
		
		
		
	}*/
	
	
	/*@Test
	public void testAddAddress() {
		user = userDao.getUser("xyz@gmail.com");
		
		address = new Address();
		address.setAddressLineOne("301/B Jadoo Society, King Uncle Nagar");
		address.setAddressLineTwo("Near Store");
		address.setCity("Banglore");
		address.setState("karntaka");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setShipping(true);	
		address.setUser(user);
		// add the address
		Assert.assertEquals("Failed to add shiipping the address!", true, userDao.addAddress(address));	
	}*/
	
	
/*	@Test
	public void testGetAddress() {
		User user =userDao.getUser("xyz@gmail.com");
		Assert.assertEquals("Failed to fetch shiipping the address!", 2, userDao.listShippingAddress(user).size());
		
		Assert.assertEquals("Failed to fetch billing the address!", "Mumbai", userDao.getBillingAddress(user).getCity());
		
	}
	*/
}


