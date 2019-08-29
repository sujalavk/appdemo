package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Dao.CategoryDao;
import com.niit.Dao.ProductDao;
import com.niit.Model.Category;
import com.niit.Model.Product;
@Controller
public class CategoryController {
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private Category category;
	
	
	@ModelAttribute("category")
	public Category defaultInstance() {
		Category category = new Category();
	  
	    return  category;
	}
	
	

	@RequestMapping(value = "/categoryAdd", method = RequestMethod.POST)
	public String insertCategory(@ModelAttribute("category") Category mcategory,BindingResult result, Model model) {
		System.out.println("category add");
		if(result.hasErrors()) {
			return"redirect:home";
		}
		if (categoryDao.insertCategory(mcategory) == true) {
			
			model.addAttribute("msg", "Successfully created/updated the caetgory");
		} else {
			model.addAttribute("msg", "not able created/updated the caetgory");
		}
		model.addAttribute("category", mcategory);
		model.addAttribute("categoryList", categoryDao.listCategories());
		model.addAttribute("isAdminClickedCategories", "true");
		
		return "redirect:Admin";
	}
	
	
	@RequestMapping("categoryEdit/{cid}")
	public String editCategory(@PathVariable("cid") String id, Model model) {
		System.out.println("editCategory");
		model.addAttribute("category", this.categoryDao.getCategoryByID(id));
		model.addAttribute("listCategory", this.categoryDao.listCategories());
		return "category";
	}
	@RequestMapping(value="categoryDelete/{cid}")
	public String deleteCategory(@PathVariable("cid")String categoryId,Model m)
	{
		Category category=categoryDao.getCategoryByID(categoryId);
		boolean productsExistWithSameCategory=false;
		for(Product product : productDao.listProducts())
		{
			if(product.getCategory_id().equals(categoryId))
			{
				productsExistWithSameCategory=true;
				break;
			}
		}
		if(productsExistWithSameCategory)
		{
			m.addAttribute("deleteError",true);
			System.out.println(productsExistWithSameCategory);
		}
		else
		{
			System.out.println(productsExistWithSameCategory);
			categoryDao.deleteCategory(category);
		}
		List<Category> categoryList=categoryDao.listCategories();
		m.addAttribute("categoryList", categoryList); 
		return "category";
	}

	
	
	
}



