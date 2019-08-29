package com.niit.Model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Category")
@Component

public class Category implements Serializable {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	String cid;
	@Column
	String cname;
	@OneToMany(targetEntity = Product.class, fetch = FetchType.EAGER, mappedBy = "category")
	private Set<Product> products = new HashSet<Product>(0);

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}
