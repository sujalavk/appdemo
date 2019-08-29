package com.niit.Dao;

import java.util.List;

import com.niit.Model.OrderDetail;



public interface OrderDao 
{
	public boolean createOrder(OrderDetail order);
	public boolean updateCartItemStatus(String username);
	public OrderDetail getOrder(int orderId);
	public List<OrderDetail> listOrders(String username);
}
