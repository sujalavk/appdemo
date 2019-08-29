package com.niit.TestCase;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.SupplierDao;
import com.niit.Model.Supplier;
import com.niit.Model.User;

public class SupplierTestCase {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Supplier supplier;

	@Autowired
	private static SupplierDao supplierDao;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		 supplier=(Supplier)context.getBean("supplier");
		supplierDao = (SupplierDao) context.getBean("supplierDao");
		System.out.println("init");
	}

@Test
public void insertSupplierTestCase()
{
	supplier.setSid("1");
	supplier.setSupplierName("farmer");
	
	
	 boolean flag = supplierDao.insertSupp(supplier);
	 
	 //compare what you are excepting VS what you are getting from save method
	 
	 Assert.assertEquals( "insertSupplierTestCase" ,true, flag);
	
	
}
@Ignore
@Test
public void updateSupplierTestCase()
{
   supplier = supplierDao.getSupplier("1");
		
		
 
   supplier.setSupplierName("padmshree");
  
   
   boolean flag = supplierDao.updateSupp(supplier);
   
   Assert.assertEquals( "updateSupplierTestCase" ,true, flag);
   
   
}

 
@Ignore

@Test
public void deleteSupplierTestCase()
{
   supplier.setSid("2");
   
   boolean flag = supplierDao.deleteSupp(supplier);
   
   Assert.assertEquals( "deleteSupplierTestCase" ,true, flag);
   
   
   
}
@Ignore
@Test
public void getSupplierTestCase() {
	supplier = supplierDao.getSupplier("1");
	  
	  
	 
	assertEquals("getSupplierTestCase","padmshree",supplier.getSupplierName());
	  
	 
}

@Test
public void listSupplierTestCase() {
	 int recordsFromDAO =  supplierDao.listSupplier().size();
	  
	  assertEquals("listSupplierTestCase" ,4, recordsFromDAO);
}
}

