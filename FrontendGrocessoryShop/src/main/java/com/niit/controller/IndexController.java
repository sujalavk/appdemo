package com.niit.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.CategoryDao;
import com.niit.Dao.ProductDao;
import com.niit.Dao.SupplierDao;
import com.niit.Dao.UserDao;
import com.niit.Model.Category;
import com.niit.Model.Product;
import com.niit.Model.Supplier;
import com.niit.Model.User;

@Controller
public class IndexController {
	@Autowired
	User user;

	@Autowired
	private Product product;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Category category;

	@Autowired
	private SupplierDao supplierDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private UserDao userDao;
	@Autowired
	private HttpSession session;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView onLoad() {

		/**
		 * Category list will load and set to session
		 * 
		 * @param session
		 * @return
		 */

		ModelAndView mv = new ModelAndView("home");
		session.setAttribute("category", category); // domain object names
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);

		session.setAttribute("categoryList", categoryDao.listCategories());

		session.setAttribute("supplierList", supplierDao.listSupplier());

		session.setAttribute("productList", productDao.listProducts());

		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView showLogin() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("isUserClickedLogin", "true");
		return mv;
	}

	// Storing supplier data
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String insertUser(@Valid @ModelAttribute("user") User muser, BindingResult result, Model model) {

		muser.setRole("ROLE_USER");
		muser.setEnabled(true);

		if (userDao.save(muser) == true) {

			model.addAttribute("msg", "Successfully created/updated the User");

		} else {
			model.addAttribute("msg", "not able created/updated the User");
		}

		model.addAttribute("user", muser);
		// model.addAttribute("userist", userDao.listSupplier());

		return "redirect:home";

	}

	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Aha! Caught You.");
		mv.addObject("errorDescription", "You are not authorized to view this page!");
		mv.addObject("title", "403 Access Denied");
		return mv;
	}

	@RequestMapping("/productlist")
	public ModelAndView showProducts() {
		ModelAndView mv = new ModelAndView("ProductList");
		mv.addObject("productList", productDao.listProducts());
		mv.addObject("isUserClickedViewProducts", "true");
		return mv;
	}

	@RequestMapping("/category")
	public ModelAndView showCategory() {
		ModelAndView mv = new ModelAndView("category");
		mv.addObject("categoryList", categoryDao.listCategories());
		mv.addObject("category", category);
		mv.addObject("isUserClickedViewCategories", "true");
		return mv;
	}
}
