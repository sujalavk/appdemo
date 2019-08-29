package com.niit.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.CartDao;
import com.niit.Model.Cart;

@Transactional
@Repository("cartDao")
public class CartDaoImpl implements CartDao {
	@Autowired
	private SessionFactory sessionFactory;

	public CartDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {

		return sessionFactory.getCurrentSession();
	}

	public boolean insertCart(Cart cart) {
		try {

			getCurrentSession().save(cart);
			System.out.println("successfully cart saved");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCart(Cart cart) {
		try {

			getCurrentSession().update(cart);
			System.out.println("successfully cart updated");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCart(String id) {
		try {
			getCurrentSession().delete(getCartByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteFromCart(Cart c) {
		try {
			getCurrentSession().delete(c);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Cart getCartByID(String id) {
		return (Cart) sessionFactory.getCurrentSession().createQuery("from Cart where id = '" + id + "'")
				.uniqueResult();
	}

	public List<Cart> listCart() {
		return getCurrentSession().createQuery("from Cart").list();
	}

	public List<Cart> userCartList(String uname) {

		List<Cart> list = sessionFactory.getCurrentSession().createQuery("from Cart where u_id=" + "'" + uname + "'")
				.list();

		if (list != null && !list.isEmpty()) {
			return list;
		}
		return null;
	}

}
