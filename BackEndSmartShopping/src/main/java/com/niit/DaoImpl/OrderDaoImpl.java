package com.niit.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Dao.OrderDao;
import com.niit.Model.OrderDetail;


@Repository("orderDao")
@Transactional
public class OrderDaoImpl implements OrderDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public OrderDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

	public boolean createOrder(OrderDetail order) 
	{
		try 
		{
			sessionFactory.getCurrentSession().save(order);
			return true;
		} 
		catch (HibernateException e) 
		{
			return false;
		}
	}

	public boolean updateCartItemStatus(String username) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("update cartitem set status='P' where username=:uname");
			query.setParameter("uname", username);
			int rowsEffected=query.executeUpdate();
			session.close();
			if(rowsEffected>0)
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<OrderDetail> listOrders(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from OrderDetail where username=:uname");
		query.setParameter("uname", username);
		List<OrderDetail> listOrders=query.list();

		return listOrders;
	}

	public OrderDetail getOrder(int orderId) 
	{
		Session session=sessionFactory.openSession();
		OrderDetail order=session.get(OrderDetail.class, orderId);
		session.close();
		return order;
	}
	public List<OrderDetail> listAllOrders() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from OrderDetail");
	
		List<OrderDetail> listOrders=query.list();
		
		return listOrders;
	}

}