package com.niit.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.CartDao;
import com.niit.Dao.CategoryDao;
import com.niit.Dao.OrderDao;
import com.niit.Dao.ProductDao;
import com.niit.Dao.SupplierDao;
import com.niit.Dao.UserDao;
import com.niit.Model.Address;
import com.niit.Model.Cart;
import com.niit.Model.Category;

import com.niit.Model.OrderDetail;
import com.niit.Model.Product;
import com.niit.Model.Supplier;
import com.niit.Model.User;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartDao cartDao;

	@Autowired
	private Cart cart;
	@Autowired
	private UserDao userDao;

	@Autowired
	private User user;

	@Autowired
	private OrderDetail order;

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private Address address;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;

	@Autowired
	private Product product;

	@RequestMapping(value = "/checkout/{sum}", method = RequestMethod.GET)
	public ModelAndView showCheckout(@PathVariable("sum") float total, HttpServletRequest request,
			Principal principal) {

		ModelAndView mv = new ModelAndView("checkout");

		user = userDao.getUser(principal.getName());
		order.setUsername(principal.getName());
		;
		order.setTotalAmount(total);
		mv.addObject("isUserClickedCheckOut", "true");
		return mv;
	}

	@RequestMapping(value = "/Add/{pid}", method = RequestMethod.GET)
	public String addToCart(@PathVariable("pid") int id, HttpServletRequest request, Principal principal, Model model) {
		try {

			Product product = productDao.getProductByID(id);

			Cart cart = new Cart();
			cart.setPrice(product.getPrice());
			cart.setP_id(product.getPid());
			cart.setP_name(product.getPname());
			cart.setQuantity(1);
			cart.setU_id(principal.getName());
			cart.setStatus("N");

			cartDao.insertCart(cart);

			model.addAttribute("cart", new Cart());
			model.addAttribute("cartList", this.cartDao.userCartList(principal.getName()));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "cart";

	}

	@RequestMapping(value = "/Delete/{pid}", method = RequestMethod.GET)
	public String deleteCart(@PathVariable("pid") String id, HttpServletRequest request, Principal principal,
			Model model) {
		try {

			cartDao.deleteCart(id);
			model.addAttribute("cartList", this.cartDao.userCartList(principal.getName()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "cart";

	}

	@RequestMapping(value = "/myCart", method = RequestMethod.GET)
	public String myCart(Model model, Principal principal) {
		try {
			model.addAttribute("cart", new Cart());
			model.addAttribute("cartList", this.cartDao.userCartList(principal.getName()));
			model.addAttribute("category", new Category());
			model.addAttribute("categoryList", this.categoryDao.listCategories());
			model.addAttribute("displayCart", "true");

			int i, j = 0;
			float s = 0;
			int n = cartDao.userCartList(principal.getName()).size();
			System.out.println(n);
			for (i = 0; i < n; i++) {
				s = s + cartDao.userCartList(principal.getName()).get(i).getPrice();
			}
			System.out.print(s);
			model.addAttribute("sum", s);

		} catch (Exception ex) {
			System.out.println("ex.getMessage");
		}
		return "cart";

	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String addorder(HttpServletRequest request, Principal principal, Model model) {
		List<Cart> cartItemList = cartDao.userCartList(principal.getName());

		model.addAttribute("orderItems", cartItemList);
		model.addAttribute("orderDetail", new OrderDetail());

		return "Order";

	}

	@RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
	public ModelAndView showInvoice(@ModelAttribute("orderDetail") OrderDetail orderdetail, Principal principal) {
		List<Cart> cartItemList = cartDao.userCartList(principal.getName());
		double grandTotal = 0;
		for (Cart ci : cartItemList) {
			Product product = productDao.getProductByID(ci.getP_id());
			// setting the price and product name so that their respective fields can be
			// populated in receipt
			ci.setP_name(product.getPname());
			ci.setPrice(product.getPrice());
			// getting the grand total amt of order
			double totalPrice = ci.getPrice() * ci.getQuantity();
			grandTotal += totalPrice;
		}
		for (Cart ci : cartItemList) {
			// delete order items from cart
			cartDao.deleteFromCart(ci);
			// update stock
			Product product = productDao.getProductByID(ci.getP_id());
			product.setStock(product.getStock() - ci.getQuantity());
			productDao.updateProduct(product);
		}
		order.setUsername(principal.getName());
		order.setPaymentMode(orderdetail.getPaymentMode());
		order.setOrderDate(new Date());
		order.setTotalAmount(grandTotal);
		orderDao.createOrder(order);
		ModelAndView mv = new ModelAndView("invoice");
		return mv;
	}

}
