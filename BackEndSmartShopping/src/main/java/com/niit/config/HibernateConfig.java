package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Dao.UserDao;
import com.niit.DaoImpl.CartDaoImpl;
import com.niit.DaoImpl.CategoryDaoImpl;
import com.niit.DaoImpl.OrderDaoImpl;
import com.niit.DaoImpl.ProductDaoImpl;
import com.niit.DaoImpl.SupplierDaoImpl;
import com.niit.DaoImpl.UserDaoImpl;
import com.niit.Model.User;

@Configuration
@EnableTransactionManagement

@ComponentScan("com.niit")
public class HibernateConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUrl("jdbc:h2:tcp://localhost/~/ecommerce");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setPassword("");

		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		//properties.put("hibernate.format_sql", "true");
	properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("inn properties");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.niit.Model" });
		sessionFactory.setHibernateProperties(getHibernateProperties());
		System.out.println("session");
		return sessionFactory;
	}

	@Autowired
	@Bean(name = "supplierDao")
	public SupplierDaoImpl getSupplierData(SessionFactory sf) {
		System.out.println("supplier dao");
		return new SupplierDaoImpl(sf);

	}

	@Autowired
	@Bean(name = "categoryDao")
	public CategoryDaoImpl getCategoryData(SessionFactory sf) {

		return new CategoryDaoImpl(sf);

	}
	@Autowired
	@Bean(name = "productDao")
	public ProductDaoImpl getProductData(SessionFactory sf) {

		return new ProductDaoImpl(sf);

	}

	@Autowired
	@Bean(name = "cartDao")
	public CartDaoImpl getCartData(SessionFactory sf) {

		return new CartDaoImpl(sf);

	}
	@Autowired
	@Bean(name = "orderDao")
	public OrderDaoImpl getOrderData(SessionFactory sf) {

		return new OrderDaoImpl(sf);

	}
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

}
