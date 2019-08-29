package com.niit.Dao;

import java.util.List;

import com.niit.Model.Cart;

public interface CartDao {
	public List<Cart>listCart();

	// create cart

	public boolean insertCart(Cart cart);

	
	public boolean updateCart(Cart cart);
	
	// delete cart by id

	public boolean deleteCart(String id);

	// delete cart by cart

	boolean deleteFromCart(Cart c);
	// get cart by id

	public Cart getCartByID(String id);

	// get cart by name
	
	 public List<Cart> userCartList(String uname);
}
