package com.niit.TestCase;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.CategoryDao;
import com.niit.Model.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Category category;

	@Autowired
	private static CategoryDao categoryDao;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		category = (Category) context.getBean("category");
		categoryDao = (CategoryDao) context.getBean("categoryDao");

	}

	@Test
	public void insertCategoryTestCase() {
		category.setCid("1");
		category.setCname("Vegitables");

		boolean flag = categoryDao.insertCategory(category);

		Assert.assertEquals("insertCategoryTestCase", true, flag);

	}

	// @Test
	// public void updateCategoryTestCase()
	// {
	// category = categoryDao.getCategoryByID("1");
	//
	//
	//
	// category.setCname("padmshree");
	//
	//
	// boolean flag = categoryDao.updateCategory(category);
	//
	// Assert.assertEquals( "updateCategoryTestCase" ,true, flag);
	//
	//
	// }
	//
	//
	//
	//
	// @Test
	// public void deleteCategoryTestCase()
	// {
	// category.setCid("2");
	//
	// boolean flag = categoryDao.deleteCategory(category);
	//
	// Assert.assertEquals( "deleteCategoryTestCase" ,true, flag);
	//
	//
	//
	// }
	//
	// @Test
	// public void getCategoryTestCase() {
	// category = categoryDao.getCategoryByID("1");
	//
	//
	//
	// assertEquals("getCategoryTestCase","padmshree",category.getCname());
	//
	//
	// }
	//
	/* @Test
	 public void listCategoryTestCase() {
	 int recordsFromDAO = categoryDao.listCategories().size();
	
	 assertEquals("listCategoryTestCase" ,1, recordsFromDAO);
	}
*/
	/*@Test
	public void getCategoryTestCase() {
		category = categoryDao.getCategoryByName("saree");

		assertEquals("getCategoryTestCase", "saree", category.getCname());
	}
*/
}
