package com.niit.Dao;

import java.util.List;

import com.niit.Model.Address;
import com.niit.Model.User;

public interface UserDao {
	 
	 
	public List<User> list();

	// create user

	public boolean save(User user);

	// update user

	public boolean update(User user);

	// delete user by id

	public boolean delete(String id);

	// delete user by user

	public boolean delete(User user);
	
	public boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);

	User getUser(String email);

}
