package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.CategoryDao;
import com.niit.Dao.ProductDao;
import com.niit.Dao.SupplierDao;
import com.niit.Model.Category;
import com.niit.Model.Product;
import com.niit.Model.Supplier;

@Controller
public class ProductController {
	@Autowired
	private ProductDao productDao;

	@Autowired
	private Category category;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private SupplierDao supplierDao;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Product product;

	private static final String UPLOAD_DIRECTORY = "D:\\GrocessoryProject\\FrontendGrocessoryShop\\src\\main\\webapp\\resources\\images\\";
	/*
	 * @ModelAttribute("product") public Product defaultInstance() { Product product
	 * = new Product();
	 * 
	 * return product; }
	 */

	// Storing product data
	@RequestMapping(value = "/productAdd", method = RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product") Product mproduct, BindingResult result, Model model,
			@RequestParam CommonsMultipartFile file, HttpSession session) {

		category = categoryDao.getCategoryByName(mproduct.getCategory_id());
		// categoryDao.insertCategory(category);
		System.out.println(mproduct.getSupplier_id());
		supplier = supplierDao.getSupplierByName(mproduct.getSupplier_id());
		// supplierDao.insertSupp(supplier);

		mproduct.setSupplier_id(supplier.getSid());
		mproduct.setCategory_id(category.getCid());

		mproduct.setCategory(category);
		mproduct.setSupplier(supplier);

		if (productDao.insertProduct(mproduct) == true) {

			System.out.println("product inserted");
			model.addAttribute("msg", "Successfully created/updated the product");
		} else {
			model.addAttribute("msg", "not able created/updated the product");
		}

		model.addAttribute("product", mproduct);
		model.addAttribute("isAdminClickedProduct", "true");
		try {
			ServletContext context = session.getServletContext();
			String path = context.getRealPath(UPLOAD_DIRECTORY);
			// String filename = file.getOriginalFilename();

			System.out.println();

			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(UPLOAD_DIRECTORY + File.separator + mproduct.getPid() + ".jpg")));
			stream.write(bytes);
			stream.flush();
			stream.close();
			System.out.println("uploaded");

		} catch (Exception e) {
			System.out.println(e);
		}

		return "redirect:Admin";

	}

	@RequestMapping("productEdit/{pid}")
	public String editProduct(@PathVariable("pid") int id, Model model) {
		System.out.println("editCategory");
		// model.addAttribute("product", this.productDao.getProductByID(id));
		model.addAttribute("listProduct", this.productDao.listProducts());
		model.addAttribute("updateProduct", this.productDao.getProductByID(id));

		model.addAttribute("categoryList", categoryDao.listCategories());
		return "UpdateProduct";
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("updateProduct") @Valid Product product, BindingResult result,
			Model m) {
		if (result.hasErrors())
			return "UpdateProduct";
		else {
			productDao.updateProduct(product);
			List<Product> productList = productDao.listProducts();
			m.addAttribute("productList", productList);
			m.addAttribute("addProduct", new Product());
			return "ProductList";
		}

	}

	@RequestMapping(value = "productDelete/{pid}")
	public String deleteProduct(@PathVariable("pid") int id, Model model) {

		System.out.println("before delete");
		try {
			System.out.println("in delete");
			productDao.deleteProduct(id);

			model.addAttribute("message", "Successfully deleted");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		List<Product> productList = productDao.listProducts();
		model.addAttribute("productList", productList);
		return "ProductList";
	}
}
