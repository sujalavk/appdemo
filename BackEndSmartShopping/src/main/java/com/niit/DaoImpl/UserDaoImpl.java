package com.niit.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.UserDao;
import com.niit.Model.Address;
import com.niit.Model.User;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	List<User> users;
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {

		return sessionFactory.getCurrentSession();
	}

	public UserDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	public List<User> list() {

		return users;
	}

	public boolean save(User user) {
		try {
			getCurrentSession().save(user);

			System.out.println("successfully created");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	

	public User getUser(String email) {
		try {			
			return sessionFactory.getCurrentSession().get(User.class, email);			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public boolean update(User user) {
		try {
			getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(User user) {
		try {
			getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	/*@Override
	public boolean addAddress(Address address) {
		try {
			getCurrentSession().save(address);

			System.out.println("successfully  address created");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}*/
	public Address getBillingAddress(User user) {
		String selectQuery = "FROM Address WHERE user = :userAND billing = :isBilling";
		try{
		return getCurrentSession().createQuery(selectQuery,Address.class).setParameter("user ", user)
						.setParameter("isBilling", true)
						.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}
	}

	public List<Address> listShippingAddress(User user) {
		String selectQuery = "FROM Address WHERE user_email = :email AND shipping = :isShipping";
		try{
		return getCurrentSession().createQuery(selectQuery,Address.class).setParameter("user", user)
						.setParameter("isShipping", true)
						.getResultList();
		}
		catch(Exception ex) {
			return null;
		}

}
	/*@Override
	public Address getBillingAddress(String email) {
		String selectQuery = "FROM Address WHERE user_email = :email AND billing = :isBilling";
		try{
		return getCurrentSession().createQuery(selectQuery,Address.class).setParameter("user_email ", email)
						.setParameter("isBilling", true)
						.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddress(String email) {
		String selectQuery = "FROM Address WHERE user_email = :email AND shipping = :isShipping";
		try{
		return getCurrentSession().createQuery(selectQuery,Address.class).setParameter("user_email", email)
						.setParameter("isShipping", true)
						.getResultList();
		}
		catch(Exception ex) {
			return null;
		}

}*/

	public boolean addAddress(Address address) {
		// TODO Auto-generated method stub
		return false;
	}
}
