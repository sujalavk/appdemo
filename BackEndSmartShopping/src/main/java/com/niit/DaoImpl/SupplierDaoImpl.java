package com.niit.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.SupplierDao;
import com.niit.Model.Category;
import com.niit.Model.Supplier;
@Transactional
@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	 public SupplierDaoImpl(SessionFactory sessionFactory) {
	
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {

	        return sessionFactory.getCurrentSession();
	    }
	 
	public boolean insertSupp(Supplier sup) {
		try {
			getCurrentSession().save(sup);
			System.out.println("successfully saved");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean updateSupp(Supplier sup) {
		try {
			getCurrentSession().update(sup);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public boolean deleteSupp(Supplier sup) {
		try {
			sessionFactory.getCurrentSession().delete(sup);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public Supplier getSupplier(String id) {
		
		  return  (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where sid = '"+id + "'").uniqueResult();
	}
	
	public Supplier getSupplierByName(String name) {
		  return  (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where suppliername = '"+name + "'").list().get(0);
	} 


	public List<Supplier> listSupplier() {
		return	sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	
	}

}
