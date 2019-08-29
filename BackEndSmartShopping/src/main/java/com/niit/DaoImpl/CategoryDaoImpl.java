package com.niit.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.CategoryDao;
import com.niit.Model.Category;

@Transactional
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {

		return sessionFactory.getCurrentSession();
	}

	public List<Category> listCategories() {
		return getCurrentSession().createQuery("from Category").list();
	}

	public boolean insertCategory(Category category) {
		try {

			getCurrentSession().saveOrUpdate(category);
			System.out.println("successfully category saved");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCategory(Category category) {
		try {
			getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean deleteCategory(String id) {
		try {
			getCurrentSession().delete(getCategoryByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCategory(Category category) {
		try {
			getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	public Category getCategoryByID(String id) {
		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where id = '" + id + "'")
				.uniqueResult();

	}

	public Category getCategoryByName(String name) {
		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where cname = '" + name + "'")
				.list().get(0);
	}

}
