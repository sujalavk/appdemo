package com.niit.DaoImpl;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.ProductDao;
import com.niit.Model.Product;
@Transactional
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}
	private Session getCurrentSession() {

        return sessionFactory.getCurrentSession();
    }
	public List<Product> listProducts() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	public boolean insertProduct(Product product) {
		try {
			
			getCurrentSession().save(product);
			System.out.println("successfully saved");
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateProduct(Product product) {
		try {
			getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
			
		}
	}

	public boolean deleteProduct(int id) {
		try {
		getCurrentSession().delete(getProductByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteProduct(Product product) {
		try {
			getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
	}

	public Product getProductByID(int id) {
		return  (Product) sessionFactory.getCurrentSession().createQuery("from Product where id = '"+id + "'").uniqueResult();
		
	}

	public Product getProductByName(String name) {
		  return  (Product) sessionFactory.getCurrentSession().createQuery("from Product where name = '"+name + "'").list().get(0);
	}
	

}
